grammar Cmm;	

@header {
	import ast.*;
	import types.*;
	import ast.definitions.*;
	import ast.statements.*;
	import ast.expressions.*;
}

/**********************************************************************************************************************/
/**************************************************** Parser rules ****************************************************/
/**********************************************************************************************************************/
program returns [Program ast]:
		definitions 'void' m='main' '(' ')' statements
		{ $ast = new Program($definitions.start.getLine(), $definitions.start.getCharPositionInLine()+1, $definitions.ast, $statements.ast); }
        ;
definitions returns [List<Definition> ast = new ArrayList<Definition>()]:
         ( typedef_definition    { $ast.addAll($typedef_definition.ast); }
         | variable_definition   { $ast.addAll($variable_definition.ast); }
         | function_definition   { $ast.add($function_definition.ast); }
         )*
         ;
//====================================================================================================================//
// VARIABLES =========================================================================================================//
//====================================================================================================================//
variable_definition returns [ArrayList<Definition> ast = new ArrayList<Definition>()]:
             (type id1=ID                    { $ast.add(new VarDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, $type.ast)); }
             (',' id2=ID                     { $ast.add(new VarDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, $type.ast)); })*) ';'
           | tvd=typedef_variable_definition { $ast.addAll($tvd.ast); }
           ;

typedef_variable_definition returns [ArrayList<Definition> ast = new ArrayList<Definition>()]
                            locals  [ArrayList<Integer> indexes = new ArrayList<>()]:
            'type' td=ID
              (( id=ID                  { $ast.add(new VarDefinition($td.getLine(), $td.getCharPositionInLine()+1, $id.text, TypedefDefinition.getTypedefType($td.text))); }
              ( ',' id2=ID              { $ast.add(new VarDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, TypedefDefinition.getTypedefType($td.text))); })* )
            | (('[' c=INT_CONSTANT ']'  { $indexes.add(LexerHelper.lexemeToInt($c.text)); })+ id=ID
                                        { $ast.add(new VarDefinition($td.getLine(), $td.getCharPositionInLine()+1, $id.text, ArrayType.createArray(TypedefDefinition.getTypedefType($td.text), $indexes))); } )) ';'
          ;
//====================================================================================================================//
// TYPES =============================================================================================================//
//====================================================================================================================//
primative returns [Type ast]:
      'int'             { $ast = IntType.getInstance(); }
    | 'double'          { $ast = RealType.getInstance(); }
    | 'char'            { $ast = CharType.getInstance(); }
    ;
type returns [Type ast] locals [ArrayList<Integer> indexes = new ArrayList<>()]:
      primative                      { $ast = $primative.ast; }
    | 'struct'                       { $ast = StructType.getInstance(); }
    | t=type ('[' c=INT_CONSTANT ']' { $indexes.add(LexerHelper.lexemeToInt($c.text)); })+ { $ast = ArrayType.createArray($t.ast, $indexes); }
    ;
//====================================================================================================================//
// STATEMENTS ========================================================================================================//
//====================================================================================================================//
statements returns [ArrayList<Statement> ast = new ArrayList<Statement>()]:
         '{' (v=variable_definition { for(Definition d: $v.ast) { $ast.add((Statement)d); } })* (s=statement { $ast.addAll($s.ast); })* '}'
         ;
statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
          locals [ArrayList<Statement> stmts = new ArrayList<Statement>()]:
             'write' e1=expression                              { $ast.add(new Write($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast)); }
             (',' e2=expression                                 { $ast.add(new Write($e2.start.getLine(), $e2.start.getCharPositionInLine()+1, $e2.ast)); })*';'
           | 'read' e1=expression                               { $ast.add(new Read($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast)); }
             (',' e2=expression                                 { $ast.add(new Read($e2.start.getLine(), $e2.start.getCharPositionInLine()+1, $e2.ast)); })*';'
           | 'if' '(' c=expression ')' ( s1=statements          { $stmts.addAll($s1.ast); } | s2=statement { $stmts.addAll($s2.ast); } )
                                                                { $ast.add(new If($c.start.getLine(), $c.start.getCharPositionInLine()+1, $c.ast, $stmts));  $stmts = new ArrayList<Statement>();}
             ('else' ( s1=statements                            { $stmts.addAll($s1.ast); } | s2=statement { $stmts.addAll($s2.ast); } )
                                                                { $ast.add(new Else($s1.start.getLine(), $s1.start.getCharPositionInLine()+1, $stmts)); $stmts = new ArrayList<Statement>();})?
           | 'while' '(' e1=expression ')' ( s1=statements      { $stmts.addAll($s1.ast); } | s2=statement { $stmts.addAll($s2.ast); } )
                                                                { $ast.add(new While($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $stmts)); $stmts = new ArrayList<Statement>();}
           | 'return' e1=expression ';'                         { $ast.add(new Return($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast)); }
           | fi=function_invocation ';'                         { $ast.add((Statement)$fi.ast); }
           | e1=expression '=' e2=expression ';'                { $ast.add(new Assignment($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast)); }
           ;
function_invocation returns [Expression ast] locals [ArrayList<Expression> parameters = new ArrayList<Expression>()]:
         id=ID '(' (e1=expression ( |',') { $parameters.add($e1.ast); })* ')'
         { $ast = new FuncExpression($id.getLine(), $id.getCharPositionInLine()+1, $id.text, $parameters); }
        ;
//====================================================================================================================//
// EXPRESSIONS =======================================================================================================//
//====================================================================================================================//
expression returns [Expression ast] locals [ArrayList<Expression> indexes = new ArrayList<Expression>()]:
           ID                                                       { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
         | e1=expression '[' e2=expression ']'                      { $ast = new Indexing($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast); }// indexing node look at arthmetic node. compomsite.
         | e1=expression '.' e2=expression                          { $ast = new StructAccess($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast); }
         | fi=function_invocation                                   { $ast = $fi.ast; }
         | i=INT_CONSTANT                                           { $ast = new IntLiteral($i.getLine(), $i.getCharPositionInLine()+1, LexerHelper.lexemeToInt($i.text)); }
         | r=REAL_CONSTANT                                          { $ast = new RealLiteral($r.getLine(), $r.getCharPositionInLine()+1, LexerHelper.lexemeToReal($r.text)); }
         | c=CHAR_CONSTANT                                          { $ast = new CharLiteral($c.getLine(), $c.getCharPositionInLine()+1, LexerHelper.lexemeToChar($c.text)); }
         | '(' e1=expression ')'                                    { $ast = $e1.ast; }
         | '(' p=primative ')' e1=expression                        { $ast = new Cast($p.start.getLine(), $p.start.getCharPositionInLine()+1, $p.ast, $e1.ast); }
         | '-' e1=expression                                        { $ast = new UnaryMinus($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast); }
		 | e1=expression op=('*'|'/'|'%')
		   e2=expression                                            { $ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
		 | e1=expression op=('+'|'-')
		   e2=expression                                            { $ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
		 | e1=expression op=('>' | '>=' | '<' | '<=' | '!=' | '==')
		   e2=expression                                            { $ast = new Comparison($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
		 | e1=expression op=( '&&' | '||' ) e2=expression           { $ast = new Logic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
		 | '!' e1=expression                                        { $ast = new Not($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast); }
         ;
//====================================================================================================================//
// FUNCTIONS =========================================================================================================//
//====================================================================================================================//
function_definition returns [Definition ast]:
    r=return_type ID '(' p=parameter_list ')' s=statements      { $ast = new FuncDefinition($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, $r.ast, $p.ast, $s.ast); }
    ;
parameter_list returns [ArrayList<Definition> ast = new ArrayList<>()]:
    (( t=primative id1=ID      { $ast.add(new VarDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, $t.ast)); } ( | ','))
    | ('type' td=ID id2=ID     { $ast.add(new VarDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, TypedefDefinition.getTypedefType($td.text))); } ( | ',')) )*
    ;
return_type returns [Type ast]:
      p=primative   { $ast = $p.ast; }
    | 'void'        { $ast = VoidType.getInstance(); }
    ;
//====================================================================================================================//
// TYPEDEF ===========================================================================================================//
//====================================================================================================================//
typedef_definition returns [ArrayList<Definition> ast = new ArrayList<Definition>()]
                   locals  [ArrayList<Integer> indexes = new ArrayList<>()]:
    'typedef' ( t=type
                ( id1=ID                    { $ast.add(new TypedefDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, $t.ast)); }
                  (',' id2=ID               { $ast.add(new TypedefDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, $t.ast)); } )* ';'
                | (('[' c=INT_CONSTANT ']'  { $indexes.add(LexerHelper.lexemeToInt($c.text)); })+ id5=ID
                                            { $ast.add(new TypedefDefinition($id5.getLine(), $id5.getCharPositionInLine()+1, $id5.text, ArrayType.createArray($t.ast, $indexes))); } ) ';')
              | 'type' td=ID
                ( id3=ID                    { $ast.add(new TypedefDefinition($id3.getLine(), $id3.getCharPositionInLine()+1, $id3.text, TypedefDefinition.getTypedefType($td.text))); }
                  (',' id4=ID               { $ast.add(new TypedefDefinition($id4.getLine(), $id4.getCharPositionInLine()+1, $id4.text, TypedefDefinition.getTypedefType($td.text))); } )* ';'
                | (('[' c=INT_CONSTANT ']'  { $indexes.add(LexerHelper.lexemeToInt($c.text)); })+ id6=ID
                                            { $ast.add(new TypedefDefinition($id6.getLine(), $id6.getCharPositionInLine()+1, $id6.text, ArrayType.createArray(TypedefDefinition.getTypedefType($td.text), $indexes))); } ) ';')
              | sd=struct_definition        { $ast.add(new TypedefDefinition($sd.ast)); })
    ;


    // TypedefDefinition.getTypedefType($td.text))
//====================================================================================================================//
// STRUCTS ===========================================================================================================//
//====================================================================================================================//
struct_definition returns [StructDefinition ast]
                  locals [ArrayList<Definition> variableDefs = new ArrayList<Definition>()]:
      t=type '{' (vd=variable_definition { $variableDefs.addAll($vd.ast); })+ '}'
      id=ID ';' { $ast =  new StructDefinition($id.getLine(), $id.getCharPositionInLine()+1, $id.text, $t.ast, $variableDefs); }
   ;

/**********************************************************************************************************************/
/**************************************************** Lexer rules *****************************************************/
/**********************************************************************************************************************/
/********************* MISC *********************/
WS: [ \t\r\n]+ -> skip
  ;

COMMENT: ( '//' .*? ('\n'|'\r'|EOF)
       | '/*' .*? '*/' ) -> skip
       ;
/********************* CHAR TYPE *********************/
CHAR_CONSTANT:  '\'' ('\\t' | '\\n' | INT_CONSTANT | '\\' INT_CONSTANT+ | .) '\''
             ;
/********************* INT TYPE *********************/
fragment
DIGIT: [0-9]
     ;

INT_CONSTANT: '0'
            | [1-9] DIGIT*
            ;
/********************* REAL TYPE *********************/
fragment
SCIENCE_NOTATION: ('E' | 'e') ('-' | '+' |  ) DIGIT+
   ;

REAL_CONSTANT: DIGIT* '.' DIGIT+ SCIENCE_NOTATION    // possible integer-part, required ".", required fractional, required science notaiton
             | DIGIT+ '.' DIGIT* SCIENCE_NOTATION    // required integer-part, required ".", possible fractional, required science notaiton
             | DIGIT+ SCIENCE_NOTATION               // required integer-part, required science notataion
             | DIGIT* '.' DIGIT+
             | DIGIT+ '.' DIGIT*
             ;
/********************* IDENTIFIER / VARIABLE NAMES *********************/
fragment
LETTER: [a-zA-Z]
    ;

ID: (LETTER | '_') (LETTER | DIGIT | '_')*
  ;


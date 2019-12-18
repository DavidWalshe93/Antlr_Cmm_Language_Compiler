grammar Cmm;

import CmmLexerRules;

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
program returns [Program ast]
    :   d=definitions   { $ast = new Program($d.start.getLine(), $d.start.getCharPositionInLine()+1, $d.ast); }
    ;
definitions returns [List<Definition> ast = new ArrayList<Definition>()]
    :   ( type_definition    { $ast.addAll($type_definition.ast); }
    	| struct_definition  { $ast.add($struct_definition.ast); }
        | variable_definition   { $ast.addAll($variable_definition.ast); }
        | function_definition   { $ast.add($function_definition.ast); }
        )*
       main                     { $ast.add($main.ast); }
    ;
main returns [Definition ast]
    :   'void' m=MAIN '(' ')'
        (   '{' '}'                { $ast = new FunctionDefinition($m.getLine(), $m.getCharPositionInLine()+1, "main", VoidType.getInstance(), new ArrayList<Definition>(), new ArrayList<Statement>()); }
        |   fb=function_block      { $ast = new FunctionDefinition($m.getLine(), $m.getCharPositionInLine()+1, "main", VoidType.getInstance(), new ArrayList<Definition>(), $fb.ast); }
        )
    ;
//====================================================================================================================//
// VARIABLES =========================================================================================================//
//====================================================================================================================//
variable_definition returns [ArrayList<Definition> ast = new ArrayList<Definition>()]
    :   (type id1=ID    { $ast.add(new VariableDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, $type.ast)); }
        (',' id2=ID     { $ast.add(new VariableDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, $type.ast)); })*)? ';'
    ;
//====================================================================================================================//
// TYPES =============================================================================================================//
//====================================================================================================================//
primative returns [Type ast]
    :   'int'     { $ast = IntType.getInstance(); }
    |   'double'  { $ast = RealType.getInstance(); }
    |   'char'    { $ast = CharType.getInstance(); }
    ;
type returns [Type ast] locals [ArrayList<Integer> indexes = new ArrayList<>()]
    :   primative                      { $ast = $primative.ast; }
    |   t=type ('[' c=INT_CONSTANT ']' { $indexes.add(LexerHelper.lexemeToInt($c.text)); })+ { $ast = ArrayType.createArray($t.ast, $indexes); }
    |   'type' id=ID                   { $ast = new UserDefinedType($id.getLine(), $id.getCharPositionInLine()+1, $id.text); }
    ;
//====================================================================================================================//
// STATEMENTS ========================================================================================================//
//====================================================================================================================//
function_block returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   '{' v=variable_definition_block { $ast.addAll($v.ast); } b=block { $ast.addAll($b.ast); }'}'
    ;
variable_definition_block returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   ( v=variable_definition { for(Definition d: $v.ast) { $ast.add((Statement)d); } }
    	| td=type_definition    { for(Definition d: $td.ast) { $ast.add((Statement)d); } }
		| sd=struct_definition  { $ast.add($sd.ast); } )*
    ;
block returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   (s=statement { $ast.addAll($s.ast); })*
    ;
statement_block returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :    '{' b=block '}' { $ast.addAll($b.ast); }
    |    s=statement     { $ast.addAll($s.ast); }
    ;
statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   ws=write_statement          { $ast.addAll($ws.ast); }
    |   rs=read_statement           { $ast.addAll($rs.ast); }
    |   ifs=if_statement            { $ast.addAll($ifs.ast); }
    |   whs=while_statement         { $ast.add($whs.ast); }
    |   res=return_statement        { $ast.add($res.ast); }
    |   as=assignment_statement     { $ast.add($as.ast); }
    |   fi=function_invocation ';'  { $ast.add((Statement)$fi.ast); }
    ;
if_statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   'if' cb1=condition_block            { $ast.add(new If($cb1.start.getLine(), $cb1.start.getCharPositionInLine()+1, $cb1.exp, $cb1.stmts));}
        ('else' sb=statement_block          { $ast.add(new Else($sb.start.getLine(), $sb.start.getCharPositionInLine()+1, $sb.ast)); })?
    ;
while_statement returns [Statement ast]
    :   'while' cb=condition_block  { $ast = new While($cb.start.getLine(), $cb.start.getCharPositionInLine()+1, $cb.exp, $cb.stmts); }
    ;
condition_block  returns [ Expression exp, ArrayList<Statement> stmts = new ArrayList<Statement>()]
    :   '(' e=expression ')' { $exp = $e.ast; }
        sb=statement_block   { $stmts.addAll($sb.ast); }
    ;
write_statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   'write' e1=expression { $ast.add(new Write($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast)); }
        (','    e2=expression { $ast.add(new Write($e2.start.getLine(), $e2.start.getCharPositionInLine()+1, $e2.ast)); } )* ';'
    ;
read_statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   'read' e1=expression { $ast.add(new Read($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast)); }
        (','   e2=expression { $ast.add(new Read($e2.start.getLine(), $e2.start.getCharPositionInLine()+1, $e2.ast)); } )* ';'
    ;
return_statement returns [Statement ast]
    :   'return' e1=expression ';'  { $ast = new Return($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast); }
    ;
assignment_statement returns [Statement ast]
    :   e1=expression '=' e2=expression ';' { $ast = new Assignment($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast); }
    ;
function_invocation returns [Expression ast]
    :   id=ID args=argument_list   { $ast = new FunctionExpression($id.getLine(), $id.getCharPositionInLine()+1,
                                     new Variable($id.getLine(), $id.getCharPositionInLine()+1, $id.text), $args.args); }
    ;
argument_list returns [ArrayList<Expression> args = new ArrayList<Expression>()]
    :   '(' (e1=expression { $args.add($e1.ast); } (',' e2=expression { $args.add($e2.ast); })*)? ')'
    ;
//====================================================================================================================//
// EXPRESSIONS =======================================================================================================//
//====================================================================================================================//
expression returns [Expression ast] locals [ArrayList<Expression> indexes = new ArrayList<Expression>()]
    :   ID                                                       { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
    |   e1=expression '[' e2=expression ']'                      { $ast = new Indexing($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast); }// indexing node look at arthmetic node. compomsite.
    |   e1=expression '.' id=ID                                  { $ast = new Dot($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $id.text); }
    |   fi=function_invocation                                   { $ast = $fi.ast; }
    |   i=INT_CONSTANT                                           { $ast = new IntLiteral($i.getLine(), $i.getCharPositionInLine()+1, LexerHelper.lexemeToInt($i.text)); }
    |   r=REAL_CONSTANT                                          { $ast = new RealLiteral($r.getLine(), $r.getCharPositionInLine()+1, LexerHelper.lexemeToReal($r.text)); }
    |   c=CHAR_CONSTANT                                          { $ast = new CharLiteral($c.getLine(), $c.getCharPositionInLine()+1, LexerHelper.lexemeToChar($c.text)); }
    |   '(' e1=expression ')'                                    { $ast = $e1.ast; }
    |   '(' p=primative ')' e1=expression                        { $ast = new Cast($p.start.getLine(), $p.start.getCharPositionInLine()+1, $p.ast, $e1.ast); }
    |   '-' e1=expression                                        { $ast = new UnaryMinus($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast); }
    |   e1=expression op=('*'|'/'|'%')
        e2=expression                                            { $ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
    |   e1=expression op=('+'|'-')
        e2=expression                                            { $ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
    |   e1=expression op=('>' | '>=' | '<' | '<=' | '!=' | '==')
        e2=expression                                            { $ast = new Comparison($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
    |   e1=expression op=( '&&' | '||' ) e2=expression           { $ast = new Logic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast); }
    |   '!' e1=expression                                        { $ast = new Not($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast); }
    ;
//====================================================================================================================//
// FUNCTIONS =========================================================================================================//
//====================================================================================================================//
function_definition returns [Definition ast]
    :   r=return_type ID p=parameter_list s=function_block      { $ast = new FunctionDefinition($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, $r.ast, $p.params, $s.ast); }
    ;
parameter_list returns [ArrayList<Definition> params = new ArrayList<Definition>()]
    :   '(' (t1=type id1=ID { $params.add(new VariableDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, $t1.ast)); }
                (',' t2=type id2=ID { $params.add(new VariableDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id2.text, $t2.ast)); })*
            )?
        ')'
    ;
return_type returns [Type ast]
    :   p=primative   { $ast = $p.ast; }
    |   'void'        { $ast = VoidType.getInstance(); }
    ;
//====================================================================================================================//
// TYPEDEF ===========================================================================================================//
//====================================================================================================================//
type_definition returns [ArrayList<Definition> ast = new ArrayList<Definition>()]
    :   'typedef' ( td=typedef_definition  { $ast.addAll( $td.ast ); }
                  | sd=struct_definition   { $ast.add( $sd.ast ); }
                  ) ';'
    ;
typedef_definition returns [ArrayList<Definition> ast = new ArrayList<Definition>()]
    :   t=type id1=ID   { $ast.add(new TypeDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, $t.ast)); }
        ( ',' id2=ID { $ast.add(new TypeDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, $t.ast)); } )*
    ;
//====================================================================================================================//
// STRUCTS ===========================================================================================================//
//====================================================================================================================//
struct_definition returns [StructDefinition ast]
    :   'struct' '{' vdb=record_definition_block '}' id=ID
        { $ast = new StructDefinition($id.getLine(), $id.getCharPositionInLine()+1, $id.text, $vdb.ast); }
    ;
record_definition_block returns [ArrayList<Definition> ast = new ArrayList<Definition>()]
    :   (v=record_definition { for(Definition d: $v.ast) { $ast.add(d); } })*
    ;
record_definition returns [ArrayList<Definition> ast = new ArrayList<Definition>()]
    :   (type id1=ID    { $ast.add(new RecordDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, $type.ast)); }
        (',' id2=ID     { $ast.add(new RecordDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, $type.ast)); })*)? ';'
    ;

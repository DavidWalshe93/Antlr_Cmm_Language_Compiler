grammar CmmStatements;

import CmmExpressions;

if_statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   'if' cb1=condition_block            { $ast.add(new If($cb1.start.getLine(), $cb1.start.getCharPositionInLine()+1, $cb1.exp, $cb1.stmts));}
        ('else' sb=statement_block)?        { $ast.add(new Else($sb.start.getLine(), $sb.start.getCharPositionInLine()+1, $sb.ast)); }
    ;
while_statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   'while' cb=condition_block  { $ast.add(new While($cb.start.getLine(), $cb.start.getCharPositionInLine()+1, $cb.exp, $cb.stmts)); }
    ;
condition_block  returns [ Expression exp, ArrayList<Statement> stmts = new ArrayList<Statement>()]
    :   '(' e=expression ')' { $exp = $e.ast; }
        sb=statement_block   { $stmts.addAll($sb.ast); }
    ;
statement_block returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :    '{' b=block '}' { $ast.addAll($b.ast); }
    |    s=statement     { $ast.addAll($s.ast); }
    ;
block returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   (s=statement { $ast.addAll($s.ast); })*
    ;
write_statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   'write' e1=expression { $ast.add(new Write($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast)); }
        (','    e2=expression { $ast.add(new Write($e2.start.getLine(), $e2.start.getCharPositionInLine()+1, $e2.ast)); } )* ';'
    ;
read_statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]
    :   'read' e1=expression { $ast.add(new Read($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast)); }
        (','   e2=expression { $ast.add(new Read($e2.start.getLine(), $e2.start.getCharPositionInLine()+1, $e2.ast)); } )* ';'
    ;
return_statement [Statement ast]
    :   'return' e1=expression ';'  { $ast = new Return($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast); }
    ;
assignment_statement [Statement ast]
    :   e1=expression '=' e2=expression ';' { $ast = new Assignment($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast); }
    ;
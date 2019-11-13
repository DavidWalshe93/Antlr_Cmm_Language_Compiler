package ast.statements;

import visitor.Visitor;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 20/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Else extends Conditional implements Statement {

    public Else(int line, int column, ArrayList<Statement> statements) {
        super(line, column, null, statements);
    }

    @Override
    public String toString() {
        return "else{" + this.getStatementsAsString() + "}\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}

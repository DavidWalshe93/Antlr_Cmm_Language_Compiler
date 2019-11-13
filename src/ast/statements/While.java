package ast.statements;

import ast.expressions.Expression;
import visitor.Visitor;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 20/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class While extends Conditional implements Statement {


    public While(int line, int column, Expression condition, ArrayList<Statement> statements) {
        super(line, column, condition, statements);
    }

    @Override
    public String toString() {
        return "while(" + this.getCondition() + ") {" + this.getStatementsAsString() + "}\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

package ast.statements;

import ast.expressions.Expression;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 20/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class If extends Conditional implements Statement {

    public If(int line, int column, Expression condition, ArrayList<Statement> statements) {
        super(line, column, condition, statements);
    }

    @Override
    public String toString() {
        return "if(" + this.getCondition().toString() + ") {" + this.getStatementsAsString() + "}";
    }
}

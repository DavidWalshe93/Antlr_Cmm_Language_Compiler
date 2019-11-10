package ast.statements;

import ast.AbstractASTNode;
import ast.expressions.Expression;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 20/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public abstract class Conditional extends AbstractASTNode implements Statement {

    private Expression condition;
    private ArrayList<Statement> statements;

    public Conditional(int line, int column, Expression condition, ArrayList<Statement> statements) {
        super(line, column);
        this.condition = condition;
        this.statements = statements;
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    public Expression getCondition() {
        return condition;
    }

    public String getStatementsAsString() {
        String spacer = "    ";
        StringBuilder statementBuilder = new StringBuilder("\n" + spacer);
        for (Statement s : this.statements) {
            statementBuilder.append(s.toString()).append("\n").append(spacer).append(spacer);
        }

        return statementBuilder.toString();
    }
}

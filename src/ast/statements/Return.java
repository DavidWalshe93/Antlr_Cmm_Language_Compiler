package ast.statements;

import ast.AbstractASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

/**
 * Author: David Walshe
 * Date: 20/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Return extends AbstractASTNode implements Statement {

    private Expression expression;

    public Return(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "return " + getExpression() + ";\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}

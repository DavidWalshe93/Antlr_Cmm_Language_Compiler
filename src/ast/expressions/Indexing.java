package ast.expressions;

import visitor.Visitor;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Indexing extends AbstractExpression {

    private Expression arrayIndex;
    private Expression expression;

    public Indexing(int line, int column, Expression expression, Expression arrayIndex) {
        super(line, column);
        this.expression = expression;
        this.arrayIndex = arrayIndex;
    }

    public Expression getArrayIndex() {
        return arrayIndex;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return this.getExpression().toString() + "[" + this.getArrayIndex() + "]";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}

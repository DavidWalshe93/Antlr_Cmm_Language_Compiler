package ast.expressions;

import types.Type;

/**
 * Author: David Walshe
 * Date: 06/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Cast extends AbstractExpression {

    private Expression expression;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.setType(type);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return String.format("(%s)%s", this.getType(), this.expression);
    }
}

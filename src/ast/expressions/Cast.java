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
    private Type castType;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.castType = type;
        this.expression = expression;
    }

    public Type getCastType() {
        return castType;
    }

    @Override
    public String toString() {
        return String.format("(%s)%s", this.getCastType(), this.expression);
    }
}

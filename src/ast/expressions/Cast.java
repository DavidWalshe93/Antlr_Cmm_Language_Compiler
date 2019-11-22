package ast.expressions;

import types.Type;
import visitor.Visitor;

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

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("(%s)%s", this.getCastType(), this.expression);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}

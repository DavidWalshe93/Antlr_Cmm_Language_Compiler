/**
 * Default implementation of expressions.
 *
 * @author Francisco Ortin
 */

package ast.expressions;

import ast.AbstractASTNode;
import types.Type;

abstract class AbstractExpression extends AbstractASTNode implements Expression {

    private Type type;
    private boolean lvalue; // remove

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Boolean getLvalue() {
        return this.lvalue;
    }

    @Override
    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }
}

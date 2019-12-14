package ast.definitions;

import ast.AbstractASTNode;
import types.Type;

/**
 * Developer: David Walshe
 * Date: 03/10/2019
 */
abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    private String name;
    private Type type;
    private int scope;

    public AbstractDefinition(int line, int column, String name, Type type) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getScope() {
        return scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public int getOffset() {
        throw new UnsupportedOperationException("Cannot get offset of " + this.getClass().getSimpleName());
    }

    @Override
    public void setOffset(int offset) {
        throw new UnsupportedOperationException("Cannot set offset of " + this.getClass().getSimpleName());
    }

}

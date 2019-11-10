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
    public Type getType() {
        return type;
    }
}

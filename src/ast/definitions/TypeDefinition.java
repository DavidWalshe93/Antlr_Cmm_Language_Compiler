package ast.definitions;

import types.Type;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class TypeDefinition extends AbstractDefinition {

    public TypeDefinition(int line, int column, String name, Type type) {
        super(line, column, name, type);
    }

    @Override
    public String toString() {
        return "typedef " + getType() + " " + getName() + ";\n";
    }
}

package ast.definitions;

import types.Type;
import types.VoidType;

import java.util.HashMap;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class TypedefDefinition extends AbstractDefinition {

    static private HashMap<String, Type> typedefs = new HashMap<>();

    private StructDefinition structDefinition;

    public TypedefDefinition(int line, int column, String name, Type type) {
        super(line, column, name, type);
        typedefs.put(name, type);
    }

    public TypedefDefinition(StructDefinition structDefinition) {
        super(structDefinition.getLine(), structDefinition.getColumn(), structDefinition.getName(), structDefinition.getType());
        this.structDefinition = structDefinition;
        typedefs.put(this.getName(), this.getType());
    }

    public static Type getTypedefType(String nameKey) {
        return typedefs.getOrDefault(nameKey, VoidType.getInstance());
    }

    @Override
    public String toString() {
        if (structDefinition != null)
            return "typedef " + this.structDefinition.toString() + ";\n";
        else
            return "typedef " + getType() + " " + getName() + ";\n";
    }
}

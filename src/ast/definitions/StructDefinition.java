package ast.definitions;

import types.Type;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class StructDefinition extends AbstractDefinition {

    private ArrayList<Definition> fields;

    public StructDefinition(int line, int column, String name, Type type, ArrayList<Definition> fields) {
        super(line, column, name, type);
        this.fields = fields;
    }

    private String getFieldsAsString() {
        StringBuilder statementBuilder = new StringBuilder("");
        for (Definition line : fields) {
            statementBuilder.append("\n    ").append(line).append(";");
        }
        if (!statementBuilder.toString().equals("")) {
            statementBuilder.append("\n");
        }

        return statementBuilder.toString();
    }

    @Override
    public String toString() {
        return this.getType() + " {" + this.getFieldsAsString() + "} " + this.getName() + "";
    }
}

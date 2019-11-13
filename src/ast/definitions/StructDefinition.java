package ast.definitions;

import ast.statements.Statement;
import types.StructType;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class StructDefinition extends AbstractDefinition {


    public StructDefinition(int line, int column, String name, ArrayList<Statement> fields) {
        super(line, column, name, new StructType(line, column, fields));
    }

    @Override
    public String toString() {
        return "typedef struct" + " {" + this.getType() + "} " + this.getName() + ";\n";
    }
}

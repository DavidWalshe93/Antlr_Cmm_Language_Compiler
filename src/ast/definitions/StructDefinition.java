package ast.definitions;

import types.StructType;
import visitor.Visitor;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class StructDefinition extends AbstractDefinition {


    public StructDefinition(int line, int column, String name, ArrayList<Definition> fields) {
        super(line, column, name, new StructType(line, column, fields));
    }

    @Override
    public String toString() {
        return "typedef struct" + " {" + this.getType() + "} " + this.getName() + ";\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}

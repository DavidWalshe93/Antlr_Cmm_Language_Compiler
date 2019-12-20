package ast.definitions;

import ast.statements.Statement;
import types.Type;
import visitor.Visitor;

/**
 * Author: David Walshe
 * Date: 24/11/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class RecordDefinition extends VariableDefinition implements Statement {

    /**
     * The offset of the variable
     */

    public RecordDefinition(int line, int column, String name, Type type) {
        super(line, column, name, type);
    }

    @Override
    public String toString() {
        return String.format("%s %s;\n", this.getType(), this.getName());
    }


	@Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

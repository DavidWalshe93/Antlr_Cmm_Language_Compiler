package types;

import ast.statements.Statement;
import visitor.Visitor;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 08/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class StructType extends AbstractType {

    private ArrayList<Statement> recordFields;

    public StructType(int line, int column, ArrayList<Statement> recordFields) {
        super(line, column);
        this.recordFields = recordFields;
    }

    public Type getType() {
        return this;
    }

    private String getRecordFieldsAsString() {
        StringBuilder statementBuilder = new StringBuilder("");
        for (Statement line : recordFields) {
            statementBuilder.append("\n    ").append(line);
        }

        return statementBuilder.toString();
    }

    @Override
    public String toString() {
        return getRecordFieldsAsString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

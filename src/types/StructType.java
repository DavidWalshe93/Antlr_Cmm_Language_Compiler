package types;

import ast.ASTNode;
import ast.definitions.Definition;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: David Walshe
 * Date: 08/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class StructType extends AbstractType {

    // Create recordField class, similar to VarDef
    private HashMap<String, Definition> recordFields;

    // Prevents hashmap return order issues
    private ArrayList<String> recordSequence;

    // Make list not Map for record lookup

    // TODO - Check to see if structs can be created type struct{...} var1, var2, var3;
    public StructType(int line, int column, ArrayList<Definition> recordFields) {
        super(line, column);
        this.recordFields = new HashMap<String, Definition>();
        this.recordSequence = new ArrayList<>();
        for (Definition recordField : recordFields) {
            if (this.recordFields.containsKey(recordField.getName()))
                new ErrorType("Repeated variable in Struct Definition", recordField);
            else {
                this.recordFields.put(recordField.getName(), recordField);
                this.recordSequence.add(recordField.getName());
            }
        }
    }

    public ArrayList<String> getRecordSequence() {
        return recordSequence;
    }

    public HashMap<String, Definition> getRecordFields() {
        return recordFields;
    }

    public Definition getRecordField(String key) {
        return recordFields.get(key);
    }

    public Type getRecordFieldType(String key) {
        return recordFields.getOrDefault(key, null).getType();
    }

    public Type getType() {
        return this;
    }

    private String getRecordFieldsAsString() {
        StringBuilder statementBuilder = new StringBuilder();
	    recordFields.forEach((k, v) -> statementBuilder.append("\nabc   ").append(v));

        return statementBuilder.toString();
    }

    @Override
    public String toString() {
        return getRecordFieldsAsString();
    }

    /**
     * Semantic Analysis
     **/

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type dot(String name, ASTNode node) {
        Type recordFieldType = this.getRecordFieldType(name);
        if (recordFieldType == null)
            return new ErrorType("atrribute " + name + " does not exist in record", node);
        else
            return recordFieldType;
    }

    /**
     * Code Generation
     **/

    @Override
    public int numberOfBytes() {
        int bytes = 0;
        for (String recordName : recordSequence) {
            bytes += recordFields.get(recordName).getType().numberOfBytes();
        }
        return bytes;
    }
}

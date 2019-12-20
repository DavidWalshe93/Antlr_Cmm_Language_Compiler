package semantic;

import ast.definitions.*;
import ast.expressions.FunctionExpression;
import ast.expressions.Variable;
import types.ErrorType;
import types.UserDefinedType;
import visitor.AbstractVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: David Walshe
 * Date: 17/11/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private SymbolTable symbolTable = new SymbolTable();
    private ErrorBuilder errorBuilder = new ErrorBuilder();

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {
        if (!symbolTable.insert(variableDefinition)) {
            new ErrorType("The variable identifier \"" + variableDefinition.getName()
                    + "\" has already been defined in this scope", variableDefinition);
        }

        // Replaces user-defined types with their correlating primitive, array or struct type
        variableDefinition.getType().accept(this, null);
        if (variableDefinition.getType() instanceof UserDefinedType) {
            variableDefinition.setType(symbolTable.find(((UserDefinedType) variableDefinition.getType()).getType()).getType());
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void param) {
        if (!symbolTable.insert(functionDefinition)) {
            new ErrorType("The function \"" + functionDefinition.getName()
                    + "\" has already been defined in this scope", functionDefinition);
        } else {
            symbolTable.set();
            super.visit(functionDefinition, param);
            symbolTable.reset();
        }
        return null;
    }

    @Override
    public Void visit(TypeDefinition typeDefinition, Void param) {
        super.visit(typeDefinition, param);
        if (!symbolTable.insert(typeDefinition)) {
            new ErrorType("The typedef \"" + typeDefinition.getName()
                    + "\" has already been defined in this scope", typeDefinition);
        }
        return null;
    }

    @Override
    public Void visit(StructDefinition structDefinition, Void param) {
        super.visit(structDefinition, param);
        if (!symbolTable.insert(structDefinition)) {
            new ErrorType("The struct \"" + structDefinition.getName()
                    + "\" has already been defined in this scope", structDefinition);
        }
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        Definition retrievedDefinition = symbolTable.find(variable.getName());
        // Check if the definition is present in the code file
        if (retrievedDefinition == null) {
            variable.setDefinition(this.errorBuilder.error(variable, "The variable identifier \"" + variable.getName() + "\" is not previously defined"));
            return null;
        }
        variable.setDefinition(retrievedDefinition);
        return null;
    }

    @Override
    public Void visit(RecordDefinition recordDefinition, Void param) {
        super.visit(recordDefinition, param);
        if (recordDefinition.getType() instanceof UserDefinedType) {
            recordDefinition.setType(symbolTable.find(((UserDefinedType) recordDefinition.getType()).getType()).getType());
        }
        return null;
    }

    @Override
    public Void visit(FunctionExpression functionExpression, Void param) {
        super.visit(functionExpression, param);
        functionExpression.setDefinition(symbolTable.find(functionExpression.getName()));
        if (functionExpression.getDefinition() == null) {
            functionExpression.setDefinition(errorBuilder.error(functionExpression, "The function identifier \"" + functionExpression.getName() + "\" is not previously defined"));
        }
        return null;
    }

    private static class SymbolTable {
        private int scope;

        private List<Map<String, Definition>> table;

        SymbolTable() {
            table = new ArrayList<>();
            table.add(new HashMap<>());
            scope = table.size() - 1;
        }

        void set() {
            table.add(new HashMap<>());
            scope = table.size() - 1;
        }

        void reset() {
            table.remove(scope);
            scope = table.size() - 1;
        }

        boolean insert(Definition definition) {
            if (table.get(scope).containsKey(definition.getName())) {
                return false;
            } else {
                definition.setScope(scope);
                table.get(scope).put(definition.getName(), definition);
                return true;
            }
        }

        Definition find(String id) {
            for (int scope = this.scope; scope >= 0; scope--) {
                if (table.get(scope).containsKey(id))
                    return table.get(scope).get(id);
            }
            return null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < table.size(); i++) {
                sb.append(i).append("[").append(i).append("] = ");
                for (String key : table.get(i).keySet()) {
                    sb.append(key).append(", ");
                }
                sb.append("\n");
            }
            sb.append("-----------------------------------");

            return sb.toString();
        }
    }

    private static class ErrorBuilder {

        VariableDefinition error(Variable variable, String errorMsg) {
            return new VariableDefinition(variable.getLine(), variable.getColumn(),
                    variable.getName(), new ErrorType(errorMsg, variable));
        }

        FunctionDefinition error(FunctionExpression functionExpression, String errorMsg) {
            return new FunctionDefinition(functionExpression.getLine(), functionExpression.getColumn(),
                    functionExpression.getName(), new ErrorType(errorMsg, functionExpression),
                    null, null);
        }
    }
}

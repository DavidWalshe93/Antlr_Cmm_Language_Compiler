package semantic;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.Assignment;
import ast.statements.Return;
import ast.statements.Statement;
import ast.statements.Write;
import types.ErrorType;
import types.FunctionType;
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

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {
        if (!symbolTable.insert(variableDefinition)) {
            new ErrorType("The variable identifier \"" + variableDefinition.getName()
                    + "\" has already been defined in this scope", variableDefinition);
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
            FunctionType functionType = (FunctionType) functionDefinition.getType();
            for (Definition parameter : functionType.getParameters())
                parameter.accept(this, null);
            for (Statement statement : functionDefinition.getBody())
                statement.accept(this, null);
            symbolTable.reset();
        }
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.setDefinition(symbolTable.find(variable.getName()));
        if (variable.getDefinition() == null) {
            variable.setDefinition(new VariableDefinition(variable.getLine(), variable.getColumn(),
                    variable.getName(), new ErrorType("The variable identifier \"" + variable.getName() + "\" is not previously defined", variable)));
        }
        return null;
    }

    @Override
    public Void visit(FunctionExpression functionExpression, Void param) {
        System.out.println(functionExpression.getName());
        functionExpression.setDefinition(symbolTable.find(functionExpression.getName()));
        if (functionExpression.getDefinition() == null) {
            functionExpression.setDefinition(new FunctionDefinition(functionExpression.getLine(), functionExpression.getColumn(),
                    functionExpression.getName(), new ErrorType("The function identifier \"" + functionExpression.getName() + "\" is not previously defined", functionExpression),
                    null, null));
        }
        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        arithmetic.getOperand1().accept(this, null);
        arithmetic.getOperand2().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Write write, Void param) {
        write.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        cast.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        comparison.getOperand1().accept(this, null);
        comparison.getOperand2().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.getArrayIndex().accept(this, null);
        indexing.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Logic logic, Void param) {
        logic.getOperand1().accept(this, null);
        logic.getOperand2().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Not not, Void param) {
        not.getOperand().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Dot dot, Void param) {
        dot.getRecord().accept(this, null);
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Return _return, Void param) {
        _return.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        assignment.getLeftHandSide().accept(this, null);
        assignment.getRightHandSide().accept(this, null);
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

        public void set() {
            table.add(new HashMap<>());
            scope = table.size() - 1;
        }

        public void reset() {
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
            for (StackTraceElement i : Thread.currentThread().getStackTrace()) {
                System.out.println(i);
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
}

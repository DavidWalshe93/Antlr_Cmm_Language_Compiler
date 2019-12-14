package codegeneration;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;
import types.FunctionType;
import types.StructType;
import visitor.AbstractVisitor;

/**
 * Author: David Walshe
 * Date: 11/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */


public class OffsetVisitor extends AbstractVisitor<ReturnBytes, Void> {

    private int currentGlobalByteSum = 0;

    // todo - change TR TP in all visits
    @Override
    public Void visit(StructType structType, ReturnBytes returnBytes) {
        int currentByteOffset = 0;
        for (String fieldName : structType.getRecordSequence()) {
            Definition field = structType.getRecordField(fieldName);
            field.getType().accept(this, null);
            System.out.println(field.getType());
            field.setOffset(currentByteOffset);
            currentByteOffset += field.getType().numberOfBytes();
        }
        return null;
    }


    @Override
    public Void visit(FunctionType functionType, ReturnBytes returnBytes) {
        returnBytes.setState(State.PARAM);
        for (Definition paramDef : functionType.getParameters()) {
            System.out.println("----------------------------------------------------------------------------");
            paramDef.accept(this, returnBytes);
            returnBytes.addParameterByteSize(paramDef.getType().numberOfBytes());
            System.out.println("----------------------------------------------------------------------------");
        }
        functionType.getReturnType().accept(this, returnBytes);

        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, ReturnBytes param) {

        ReturnBytes returnBytes = new ReturnBytes(State.LOCAL);
        functionDefinition.getType().accept(this, returnBytes);
        returnBytes.setReturnByteSize(((FunctionType) functionDefinition.getType()).getReturnType().numberOfBytes());


        // todo - calc
        returnBytes.setState(State.LOCAL);
        for (Statement stmt : functionDefinition.getBody()) {
            if (stmt instanceof VariableDefinition) {
                System.out.println("==============================================================");
                stmt.accept(this, returnBytes);
                returnBytes.addLocalByteSize(((VariableDefinition) stmt).getType().numberOfBytes());
                System.out.println("==============================================================");
            } else {
                // recursive for if/while, implement in visit here.
                stmt.accept(this, returnBytes); // pass object with 3 fields bytes of params, locals, return_value
            }
        }
        // todo - if def is void ret params, locals, return
        return null;
    }

    public Void visit(Variable variable, ReturnBytes returnBytes) {
        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, ReturnBytes returnBytes) {
        variableDefinition.getType().accept(this, returnBytes);
        System.out.println(returnBytes);
        if (variableDefinition.getScope() == 0) {
            variableDefinition.setOffset(currentGlobalByteSum);
            this.currentGlobalByteSum += variableDefinition.getType().numberOfBytes();
        } else {
            if (returnBytes.getState() == State.LOCAL) {
                variableDefinition.setOffset(returnBytes.getLocalsByteSize());
                System.out.println("LOCAL - " + variableDefinition);
            } else if (returnBytes.getState() == State.PARAM) {
                variableDefinition.setOffset(returnBytes.getParametersByteSize());
                System.out.println("PARAM - " + variableDefinition);
            }

            // TODO - figure out local/global allocation
        }
        return null;
    }
}

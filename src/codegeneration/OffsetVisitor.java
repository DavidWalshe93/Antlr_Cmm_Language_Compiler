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

    @Override
    public Void visit(StructType structType, ReturnBytes returnBytes) {
        int currentByteOffset = 0;
        for (String fieldName : structType.getRecordSequence()) {
            Definition field = structType.getRecordField(fieldName);
            field.getType().accept(this, null);
            field.setOffset(currentByteOffset);
            currentByteOffset += field.getType().numberOfBytes();
        }
        return null;
    }


    @Override
    public Void visit(FunctionType functionType, ReturnBytes returnBytes) {
        returnBytes.setState(State.PARAM);
        for (int i = functionType.getParameters().size() - 1; i >= 0; i--) {
            Definition paramDef = functionType.getParameters().get(i);
            paramDef.accept(this, returnBytes);
            returnBytes.addParameterByteSize(paramDef.getType().numberOfBytes());
        }
        functionType.getReturnType().accept(this, returnBytes);

        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, ReturnBytes param) {

        ReturnBytes returnBytes = new ReturnBytes(State.LOCAL);
        functionDefinition.getType().accept(this, returnBytes);
        returnBytes.setReturnByteSize(((FunctionType) functionDefinition.getType()).getReturnType().numberOfBytes());

        returnBytes.setState(State.LOCAL);
        for (Statement stmt : functionDefinition.getBody()) {
            if (stmt instanceof VariableDefinition) {
                stmt.accept(this, returnBytes);
                returnBytes.addLocalByteSize(((VariableDefinition) stmt).getType().numberOfBytes());
            } else {
                // todo - recursive for if/while, implement in visit here.
                stmt.accept(this, returnBytes);
            }
        }
        // todo - if def is void ret bytesToReturn, bytesOfLocals, bytesOfParams
        return null;
    }

    public Void visit(Variable variable, ReturnBytes returnBytes) {
        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, ReturnBytes returnBytes) {
        variableDefinition.getType().accept(this, returnBytes);
        if (variableDefinition.getScope() == 0) {
            variableDefinition.setOffset(currentGlobalByteSum);
            this.currentGlobalByteSum += variableDefinition.getType().numberOfBytes();
        } else {
            if (returnBytes.getState() == State.LOCAL) {
                variableDefinition.setOffset(returnBytes.getLocalsByteSize() - variableDefinition.getType().numberOfBytes());
            } else if (returnBytes.getState() == State.PARAM) {
                variableDefinition.setOffset(returnBytes.getParametersByteSize());
            }
        }
        return null;
    }
}

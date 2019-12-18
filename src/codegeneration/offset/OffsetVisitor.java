package codegeneration.offset;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.StructDefinition;
import ast.definitions.VariableDefinition;
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
	public Void visit(StructDefinition structDefinition, ReturnBytes returnBytes) {
		super.visit(structDefinition, null);
		structDefinition.setOffset(currentGlobalByteSum);

//        StructType st = (StructType) structDefinition.getType();
//        this.currentGlobalByteSum += (st).getRecordFields().get(st.getRecordSequence().get(st.getRecordSequence().size()-1)).getOffset();

		return null;
	}

    @Override
    public Void visit(StructType structType, ReturnBytes returnBytes) {
        int currentByteOffset = 0;
        for (String fieldName : structType.getRecordSequence()) {
            Definition field = structType.getRecordField(fieldName);
            field.getType().accept(this, null);
            field.setOffset(currentByteOffset);
            currentByteOffset += field.getType().numberOfBytes();
        }
	    this.currentGlobalByteSum += currentByteOffset;
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
	        System.out.println(stmt.getClass().getSimpleName());
	        stmt.accept(this, returnBytes);
	        if (stmt instanceof VariableDefinition) {
                returnBytes.addLocalByteSize(((VariableDefinition) stmt).getType().numberOfBytes());
	        }
	        // CHECK - What does return statement provide? Why do we need to be recursive for return?
	        // todo - recursive for if/while, implement in visit here.
        }
	    functionDefinition.setLocalsByteSize(returnBytes.getLocalsByteSize());
	    functionDefinition.setParametersByteSize(returnBytes.getParametersByteSize());
	    functionDefinition.setReturnByteSize(returnBytes.getReturnByteSize());
        return null;
    }

	//    public Void visit(Variable variable, ReturnBytes returnBytes) {
//        return null;
//    }
//
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
	            variableDefinition.setOffset(returnBytes.getParametersByteSize() + 4);
            }
        }
        return null;
    }
}

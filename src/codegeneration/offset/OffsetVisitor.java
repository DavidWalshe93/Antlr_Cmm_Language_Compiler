package codegeneration.offset;

import ast.definitions.*;
import ast.expressions.Variable;
import ast.statements.Statement;
import codegeneration.ReturnInformation;
import codegeneration.State;
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


public class OffsetVisitor extends AbstractVisitor<ReturnInformation, Void> {

    private int currentGlobalByteSum = 0;

	@Override
	public Void visit(TypeDefinition typeDefinition, ReturnInformation returnInformation) {
		if (typeDefinition.getScope() == 0) {
			typeDefinition.setOffset(currentGlobalByteSum);
			currentGlobalByteSum += typeDefinition.getType().numberOfBytes();
		} else {
			typeDefinition.setOffset(returnInformation.getLocalsByteSize() - typeDefinition.getType().numberOfBytes());
		}

		return null;
	}

	@Override
	public Void visit(StructDefinition structDefinition, ReturnInformation returnInformation) {
		StructType st = ((StructType) structDefinition.getType());
		Definition lastField = st.getRecordField(st.getRecordSequence().get(st.getRecordSequence().size() - 1));
		if (structDefinition.getScope() == 0) {
			structDefinition.getType().accept(this, new ReturnInformation(State.GLOBAL));
			structDefinition.setOffset(currentGlobalByteSum);
			currentGlobalByteSum += lastField.getOffset();
		} else {
			returnInformation.setState(State.LOCAL);
			structDefinition.getType().accept(this, returnInformation);

			structDefinition.setOffset((returnInformation.getLocalsByteSize() - lastField.getOffset()) - lastField.getType().numberOfBytes());
		}

		return null;
	}

    @Override
    public Void visit(StructType structType, ReturnInformation returnInformation) {
	    int currentByteOffset = 0;

        for (String fieldName : structType.getRecordSequence()) {
            Definition field = structType.getRecordField(fieldName);
            field.getType().accept(this, null);
	        field.setOffset(currentByteOffset);
//            if(returnBytes.getState() == State.LOCAL)
//                currentByteOffset += field.getType().numberOfBytes();
//            else
	        currentByteOffset += field.getType().numberOfBytes();


        }
        return null;
    }


    @Override
    public Void visit(FunctionType functionType, ReturnInformation returnInformation) {
	    returnInformation.setState(State.PARAM);
        for (int i = functionType.getParameters().size() - 1; i >= 0; i--) {
            Definition paramDef = functionType.getParameters().get(i);
	        paramDef.accept(this, returnInformation);
	        returnInformation.addParameterByteSize(paramDef.getType().numberOfBytes());
        }
	    functionType.getReturnType().accept(this, returnInformation);

        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, ReturnInformation param) {

	    ReturnInformation returnInformation = new ReturnInformation(State.LOCAL);
	    functionDefinition.getType().accept(this, returnInformation);
	    returnInformation.setReturnByteSize(((FunctionType) functionDefinition.getType()).getReturnType().numberOfBytes());

	    returnInformation.setState(State.LOCAL);
	    functionDefinition.getLocalVariables();
        for (Statement stmt : functionDefinition.getBody()) {
	        stmt.accept(this, returnInformation);
	        if (stmt instanceof Definition) {
		        returnInformation.addLocalByteSize(((Definition) stmt).getType().numberOfBytes());
	        }
	        // CHECK - What does return statement provide? Why do we need to be recursive for return?
	        // todo - recursive for if/while, implement in visit here.
        }
	    functionDefinition.setLocalsByteSize(returnInformation.getLocalsByteSize());
	    functionDefinition.setParametersByteSize(returnInformation.getParametersByteSize());
	    functionDefinition.setReturnByteSize(returnInformation.getReturnByteSize());
        return null;
    }

	public Void visit(Variable variable, ReturnInformation returnInformation) {
		return null;
	}

    @Override
    public Void visit(VariableDefinition variableDefinition, ReturnInformation returnInformation) {
	    variableDefinition.getType().accept(this, returnInformation);
        if (variableDefinition.getScope() == 0) {
            variableDefinition.setOffset(currentGlobalByteSum);
            this.currentGlobalByteSum += variableDefinition.getType().numberOfBytes();
        } else {
	        if (returnInformation.getState() == State.LOCAL) {
		        variableDefinition.setOffset(returnInformation.getLocalsByteSize() - variableDefinition.getType().numberOfBytes());
	        } else if (returnInformation.getState() == State.PARAM) {
		        variableDefinition.setOffset(returnInformation.getParametersByteSize() + 4);
            }
        }
        return null;
    }
}

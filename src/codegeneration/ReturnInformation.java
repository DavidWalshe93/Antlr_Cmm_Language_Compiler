package codegeneration;

import types.Type;

/**
 * Author: David Walshe
 * Date: 13/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */


public class ReturnInformation {

    private int localsByteSize = 0;
	private int parametersByteSize = 0;
    private int returnByteSize = 0;
    private State state;
	private Type returnType;

	public ReturnInformation(State state) {
        this.state = state;
    }

	public ReturnInformation(int returnByteSize, int localsByteSize, int parametersByteSize, Type returnType) {
		this.returnByteSize = returnByteSize;
		this.localsByteSize = localsByteSize;
		this.parametersByteSize = parametersByteSize;
		this.returnType = returnType;
		this.state = State.LOCAL;
	}

    public void addLocalByteSize(int value) {
        this.localsByteSize -= Math.abs(value);
    }

    public void addParameterByteSize(int value) {
        this.parametersByteSize += value;
    }

    public int getLocalsByteSize() {
        return localsByteSize;
    }

    public int getParametersByteSize() {
        return parametersByteSize;
    }

    public int getReturnByteSize() {
        return returnByteSize;
    }

    public void setReturnByteSize(int returnByteSize) {
        this.returnByteSize = returnByteSize;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

	public Type getReturnType() {
		return returnType;
	}

	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}

    @Override
    public String toString() {
        return "localVariableByteSize: " + this.getLocalsByteSize() + "\n" +
                "parameterByteSize: " + this.getParametersByteSize() + "\n" +
                "returnByteSize: " + this.getReturnByteSize() + "\n" +
                "state: " + this.state + "\n" +
                "ret " + this.getReturnByteSize() + " " + this.getLocalsByteSize() + " " + this.getParametersByteSize();
    }
}

package codegeneration;

/**
 * Author: David Walshe
 * Date: 13/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */


public class ReturnBytes {

    // todo public fields for
    private int localsByteSize;
    private int parametersByteSize;
    private int returnByteSize;
    private State state;

    public ReturnBytes() {
        this.localsByteSize = 0;
        this.parametersByteSize = 0;
        this.returnByteSize = 0;
        this.state = State.LOCAL;
    }

    public ReturnBytes(State state) {
        this.localsByteSize = 0;
        this.parametersByteSize = 0;
        this.returnByteSize = 0;
        this.state = state;
    }

    public ReturnBytes(int localsByteSize, int parametersByteSize, int returnByteSize) {
        this.localsByteSize = localsByteSize;
        this.parametersByteSize = parametersByteSize;
        this.returnByteSize = returnByteSize;
        this.state = State.LOCAL;
    }

    public ReturnBytes(int localsByteSize, int parametersByteSize, int returnByteSize, State state) {
        this.localsByteSize = localsByteSize;
        this.parametersByteSize = parametersByteSize;
        this.returnByteSize = returnByteSize;
        this.state = state;
    }

    public void addLocalByteSize(int value) {
        System.out.println(value + "  VALUE");
        this.localsByteSize -= Math.abs(value);
    }

    public void addParameterByteSize(int value) {
        this.parametersByteSize += value;
    }

    public int getLocalsByteSize() {
        return localsByteSize;
    }

    public void setLocalsByteSize(int localsByteSize) {
        this.localsByteSize = localsByteSize;
    }

    public int getParametersByteSize() {
        return parametersByteSize;
    }

    public void setParametersByteSize(int parametersByteSize) {
        this.parametersByteSize = parametersByteSize;
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

    @Override
    public String toString() {
        return "localVariableByteSize: " + this.getLocalsByteSize() + "\n" +
                "parameterByteSize: " + this.getParametersByteSize() + "\n" +
                "returnByteSize: " + this.getReturnByteSize() + "\n" +
                "state: " + this.state;
    }
}

package codegeneration.offset;

/**
 * Author: David Walshe
 * Date: 13/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */


public class ReturnBytes {

    private int localsByteSize = 0;
	private int parametersByteSize = 0;
    private int returnByteSize = 0;
    private State state;

    public ReturnBytes(State state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "localVariableByteSize: " + this.getLocalsByteSize() + "\n" +
                "parameterByteSize: " + this.getParametersByteSize() + "\n" +
                "returnByteSize: " + this.getReturnByteSize() + "\n" +
                "state: " + this.state + "\n" +
                "ret " + this.getReturnByteSize() + " " + this.getLocalsByteSize() + " " + this.getParametersByteSize();
    }
}

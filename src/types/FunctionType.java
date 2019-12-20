package types;

import ast.ASTNode;
import ast.definitions.Definition;
import visitor.Visitor;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 05/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class FunctionType extends AbstractType {

    private Type returnType;
    private ArrayList<Definition> parameters;

    public FunctionType(int line, int column, Type returnType, ArrayList<Definition> parameters) {
        super(line, column);
        this.returnType = returnType;
        this.parameters = parameters;
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public ArrayList<Definition> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "Return Type: " + this.getReturnType() + "\n" +
                "Parameters:  " + this.getParameters();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Type parenthesis(ArrayList<Type> invocationTypes, ASTNode node) {

	    checkParameterLength(invocationTypes, node);

        return this.getReturnType();
    }

	private void checkParameterLength(ArrayList<Type> invocationTypes, ASTNode node) {
        if (this.getParameters().size() == invocationTypes.size()) {
	        checkParameterTypes(invocationTypes, node);
        } else {
	        new ErrorType(this.parameters.size() + " parameters required but " + invocationTypes.size() + " were passed", node);
        }
    }

	private void checkParameterTypes(ArrayList<Type> invocationTypes, ASTNode node) {
        Type definitionType, invocationType;

        for (int i = 0; i < this.getParameters().size(); i++) {
            definitionType = this.getParameters().get(i).getType();
            invocationType = invocationTypes.get(i);

            if (invocationType != definitionType) {
	            invocationType.promote(definitionType, node);
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Type returns(Type returnType, ASTNode node) {
        return this.getReturnType().returns(returnType, node);
    }

    /**
     * Code Generation
     **/

    @Override
    public int numberOfBytes() {
        int totalNumberOfBytes = 0;

        for (Definition parameter : this.getParameters()) {
            totalNumberOfBytes += parameter.getType().numberOfBytes();
        }

        return totalNumberOfBytes;
    }
}

package types;

import ast.ASTNode;
import ast.definitions.Definition;
import ast.expressions.FunctionExpression;
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
        // CHECK - 1) [type-checking] Implementation correct for functionExpression

        ArrayList<Type> inferredTypes = checkParameterLength(invocationTypes, node);

        for (int i = 0; i < inferredTypes.size(); i++) {
            if (inferredTypes.get(i) instanceof ErrorType)
                break;
            ((FunctionExpression) node).getParameters().get(i).setType(inferredTypes.get(i));
        }

        return this.getReturnType();
    }

    private ArrayList<Type> checkParameterLength(ArrayList<Type> invocationTypes, ASTNode node) {
        if (this.getParameters().size() == invocationTypes.size()) {
            return checkParameterTypes(invocationTypes, node);
        } else {
            ArrayList<Type> inferredTypes = new ArrayList<>();
            inferredTypes.add(new ErrorType(this.parameters.size() + " parameters required but " + invocationTypes.size() + " were passed", node));
            return inferredTypes;
        }
    }

    private ArrayList<Type> checkParameterTypes(ArrayList<Type> invocationTypes, ASTNode node) {
        ArrayList<Type> inferredTypes = new ArrayList<>();
        Type definitionType, invocationType;

        for (int i = 0; i < this.getParameters().size(); i++) {
            definitionType = this.getParameters().get(i).getType();
            invocationType = invocationTypes.get(i);

            if (invocationType != definitionType) {
                inferredTypes.add(invocationType.promote(definitionType, node));
            } else {
                inferredTypes.add(invocationType);
            }
        }
        return inferredTypes;
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

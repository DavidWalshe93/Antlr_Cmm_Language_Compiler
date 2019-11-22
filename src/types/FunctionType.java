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
        return checkParameterLength(invocationTypes, node);
    }

    private Type checkParameterLength(ArrayList<Type> invocationTypes, ASTNode node) {
        if (this.getParameters().size() == invocationTypes.size()) {
            return checkParameterTypes(invocationTypes, node);
        } else
            return new ErrorType(this.parameters.size() + " parameters required but " + invocationTypes.size() + " were passed", node);
    }

    private Type checkParameterTypes(ArrayList<Type> invocationTypes, ASTNode node) {
        for (int i = 0; i < this.getParameters().size(); i++) {
            Type definitionType = this.getParameters().get(i).getType();
            if (definitionType != invocationTypes.get(i)) {
                return new ErrorType("Type " + invocationTypes.get(i) + " of passed parameter does not match type " + definitionType + " in definition", node);
            }
        }
        return this.returnType;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Type returns(Type returnType, ASTNode node) {
        return returnType.returns(this.getReturnType(), node);
//        System.out.println(returnType);
//        if(returnType instanceof RealType)
//            return RealType.getInstance();
//        if(returnType instanceof IntType);
//        if (returnType != this.returnType) {
//            return new ErrorType("The type returned: '" + returnType + "' does not match the return type: '" + this.getReturnType() + "'", node);
//        }
//        return this.returnType;
    }
}

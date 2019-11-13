package types;

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

    public Type getType() {
        return this;
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



}

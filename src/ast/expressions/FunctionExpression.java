package ast.expressions;

import ast.definitions.Definition;
import ast.statements.Statement;
import types.FunctionType;
import types.Type;
import visitor.Visitor;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class FunctionExpression extends AbstractExpression implements Statement {

    private Variable name;
    private ArrayList<Expression> parameters;
    private Definition definition;

    public FunctionExpression(int line, int column, Variable name, ArrayList<Expression> parameters) {
        super(line, column);
        this.name = name;
        this.parameters = parameters;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    @Override
    public Type getType() {
        return ((FunctionType) this.getDefinition().getType()).getReturnType();
    }

    public String getName() {
        return name.getName();
    }

    public ArrayList<Expression> getParameters() {
        return parameters;
    }

    private String getParametersAsString() {
        StringBuilder parameterBuilder = new StringBuilder();
        for (int i = 0; i < getParameters().size(); i++) {
            if (i > getParameters().size() - 1)
                break;
            parameterBuilder.append(getParameters().get(i)).append(",");
        }

        return parameterBuilder.toString();
    }

    @Override
    public String toString() {
        return getName() + "(" + this.getParametersAsString() + ");\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}

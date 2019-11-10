package ast.expressions;

import ast.definitions.Definition;
import ast.statements.Statement;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class FuncExpression extends AbstractExpression implements Statement {

    private String name;
    private ArrayList<Expression> parameters;
    private Definition definition;

    public FuncExpression(int line, int column, String name, ArrayList<Expression> parameters) {
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

    public String getName() {
        return name;
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
}

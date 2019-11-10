package ast.definitions;

import ast.statements.Statement;
import types.Type;

import java.util.ArrayList;

/**
 * Developer: David Walshe
 * Date: 03/10/2019
 */
public class FuncDefinition extends AbstractDefinition {

    private ArrayList<Definition> parameters;
    private ArrayList<Statement> body;

    public FuncDefinition(int line, int column, String name, Type type, ArrayList<Definition> parameterDefinitions, ArrayList<Statement> body) {
        super(line, column, name, type);
        this.parameters = parameterDefinitions;
        this.body = body;
    }

    private String getStatementsAsString() {
        StringBuilder statementBuilder = new StringBuilder("");
        for (Statement line : body) {
            statementBuilder.append("\n    ").append(line).append(";");
        }
        if (!statementBuilder.toString().equals("")) {
            statementBuilder.append("\n");
        }

        return statementBuilder.toString();
    }

    private String getParametersAsString() {
        StringBuilder parameterBuilder = new StringBuilder();
        for (int i = 0; i < parameters.size(); i++) {
            parameterBuilder.append(parameters.get(i));
            if (i >= parameters.size() - 1)
                break;
            parameterBuilder.append(", ");
        }
        return parameterBuilder.toString();
    }

    public String toString() {
        return String.format("%s %s(%s) {%s}\n", this.getType(), this.getName(), this.getParametersAsString(),
                this.getStatementsAsString());
    }

}

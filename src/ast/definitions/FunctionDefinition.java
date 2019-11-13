package ast.definitions;

import ast.statements.Statement;
import types.FunctionType;
import types.Type;
import visitor.Visitor;

import java.util.ArrayList;

/**
 * Developer: David Walshe
 * Date: 03/10/2019
 */
public class FunctionDefinition extends AbstractDefinition {


    private ArrayList<Statement> body;

    public FunctionDefinition(int line, int column, String name, Type returnType, ArrayList<Definition> parameters, ArrayList<Statement> body) {
        super(line, column, name, new FunctionType(line, column, returnType, parameters));
        this.body = body;
    }

    private String getParametersAsString(ArrayList<Definition> parameters) {
        StringBuilder parameterBuilder = new StringBuilder();
        for (int i = 0; i < parameters.size(); i++) {
            parameterBuilder.append(parameters.get(i));
            if (i >= parameters.size() - 1)
                break;
            parameterBuilder.append(", ");
        }
        return parameterBuilder.toString();
    }

    private String getStatementsAsString() {
        StringBuilder statementBuilder = new StringBuilder("");
        for (Statement line : body) {
            statementBuilder.append("\n    ").append(line.toString().trim());
        }
        if (!statementBuilder.toString().equals("")) {
            statementBuilder.append("\n");
        }
        return statementBuilder.toString();
    }

    public String toString() {
        FunctionType type = (FunctionType) this.getType();
        return String.format("%s %s(%s) {%s}\n", type.getReturnType(), this.getName(),
                this.getParametersAsString(type.getParameters()), this.getStatementsAsString());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

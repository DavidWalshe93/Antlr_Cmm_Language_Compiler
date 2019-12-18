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
    private int localsByteSize = 0;
    private int parametersByteSize = 0;
    private int returnByteSize = 0;

    public FunctionDefinition(int line, int column, String name, Type returnType, ArrayList<Definition> parameters, ArrayList<Statement> body) {
        super(line, column, name, new FunctionType(line, column, returnType, parameters));
        this.body = body;
    }

    public ArrayList<Statement> getBody() {
        return body;
    }

    public ArrayList<Statement> getStatements() {
        ArrayList<Statement> statements = new ArrayList<>(body);

        statements.removeIf(s -> (s instanceof VariableDefinition));
        return statements;
    }

    public ArrayList<Statement> getLocalVariables() {
        ArrayList<Statement> localVariables = new ArrayList<>(body);

        localVariables.removeIf(s -> !(s instanceof VariableDefinition));
        return localVariables;
    }

    public Type getReturnType() {
        return ((FunctionType) this.getType()).getReturnType();
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
        StringBuilder statementBuilder = new StringBuilder();
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

    public int getLocalsByteSize() {
        return localsByteSize;
    }

    /**
     * Code Generation
     **/

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
}

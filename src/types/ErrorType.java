/**
 * ErrorType represents a semantic error in the source program.
 * Assigning ErrorType as the type of one expressions means that it is erroneous.
 * In this way, erroneous and correct expressions are treated uniformly.
 *
 * @author Francisco Ortin
 */

package types;


import ast.ASTNode;
import errorhandler.ErrorHandler;
import visitor.Visitor;

import java.util.ArrayList;

public class ErrorType extends AbstractType {

    private String message;

    public ErrorType(String message, ASTNode astNode) {
        super(astNode.getLine(), astNode.getColumn());
        this.message = message;
        ErrorHandler.getErrorHandler().addError(this);
    }

    @Override
    public String toString() {
        return String.format("Error[%3d:%3d]\t%s.",
                this.getLine(), this.getColumn(), this.message);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type comparison(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type assignment(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type logic(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type parenthesis(ArrayList<Type> invocationTypes, ASTNode node) {
        return this;
    }

    @Override
    public Type dot(String name, ASTNode node) {
        return this;
    }

    @Override
    public Type arithmetic(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type promote(Type type, ASTNode astNode) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type returns(Type type, ASTNode node) {
        return this;
    }
}

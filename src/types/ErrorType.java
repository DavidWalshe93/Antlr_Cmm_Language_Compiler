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

public class ErrorType extends AbstractType {

    private String message;

    public ErrorType(String message, ASTNode astNode) {
        super(astNode.getLine(), astNode.getColumn());
        this.message = message;
        ErrorHandler.getErrorHandler().addError(this);
    }

    @Override
    public String toString() {
        return String.format("Type error in line %d and column %d: %s.",
                this.getLine(), this.getColumn(), this.message);
    }

}

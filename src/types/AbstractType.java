/**
 * Default implementation of Type.
 *
 * @author Francisco Ortin
 */

package types;


import ast.ASTNode;
import ast.AbstractASTNode;

import java.util.ArrayList;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    /******** Semantic Analysis ***************/

    @Override
    public Type arithmetic(Type type, ASTNode node) {
        // * By default, not allowed (type error)
        if (type instanceof ErrorType)
            return type;
        return new ErrorType("An arithmetic expression cannot be performed with the types " + this.getClass().getSimpleName() + " and " + type.getClass().getSimpleName() + ".", node);
    }


    @Override
    public Type assignment(Type type, ASTNode node) {
        if (type instanceof ErrorType)
            return type;
        if (this.getClass().equals(type.getClass()))
            // * Both operands have the same type
            return type;
        return new ErrorType(this + " cannot be assigned to " + type, node);
    }

    @Override
    public Type squareBrackets(Type type, ASTNode node) {
        if (type instanceof ErrorType)
            return type;
        return new ErrorType("Cannot use array notation with " + type + " type", node);
    }

    @Override
    public Type parenthesis(ArrayList<Type> invocationTypes, ASTNode node) {
        return new ErrorType("is not callable", node);
    }

    @Override
    public Type dot(String name, ASTNode node) {
        return new ErrorType("Record access is not supported with non-record type", node);
    }

    @Override
    public Type comparison(Type type, ASTNode node) {
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(type + " type is not comparable", node);
    }

    @Override
    public Type logic(Type type, ASTNode node) {
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(type + " type cannot be used in logic expressions", node);
    }

    @Override
    public Type returns(Type type, ASTNode node) {
        if (type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type promote(Type type, ASTNode astNode) {
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(type + " type cannot be promoted", astNode);
    }
}

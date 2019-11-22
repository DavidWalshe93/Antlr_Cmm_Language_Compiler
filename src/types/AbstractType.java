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
        if (type instanceof types.ErrorType)
            return type;
        if (this.getClass().equals(type.getClass()))
            // * Both operands have the same type
            return type;
        return new ErrorType("Assignments require left- and right-hand sides to have the same type", node);
    }

    @Override
    public Type squareBrackets(Type type, ASTNode node) {
        if (type instanceof ErrorType)
            return type;
        return new ErrorType("Cannot use array notation with " + type + " type", node);
    }

    @Override
    public Type parenthesis(ArrayList<Type> types, ASTNode node) {
        for (Type type : types)
            if (type instanceof ErrorType)
                return type;
        return new ErrorType(node + " type is not callable", node);
    }

    @Override
    public Type dot(Type type, ASTNode node) {
        if (type instanceof ErrorType)
            return type;
        return new ErrorType("Record access is not supported with " + type + " type", node);
    }

    @Override
    public Type comparison(Type type, ASTNode node) {
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(type + " type is not comparable", node);
    }

    @Override
    public Type returns(Type type, ASTNode astNode) {
        if (type instanceof ErrorType)
            return type;
        return null;
    }
}

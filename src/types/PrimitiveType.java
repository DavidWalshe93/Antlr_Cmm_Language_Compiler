package types;

import ast.ASTNode;

/**
 * Author: David Walshe
 * Date: 21/11/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public abstract class PrimitiveType extends AbstractType {

    PrimitiveType(int line, int column) {
        super(line, column);
    }

    abstract Type typeInference(Type type, ASTNode node, String errorMsg);

    @Override
    public Type assignment(Type type, ASTNode node) {
        String errorMsg = this + " cannot be assigned to " + type;
        return this.typeInference(type, node, errorMsg);
    }

    @Override
    public Type returns(Type type, ASTNode node) {
        if (type instanceof VoidType) {
            return new ErrorType("Cannot return '" + this.getClass().getSimpleName() + "' if void is specified as the return type in function signature", node);
        }
        String errorMsg = "Cannot return '" + this + "' for function return signature of type '" + type + "'";
        return typeInference(type, node, errorMsg);
    }

    @Override
    public Type logic(Type type, ASTNode node) {
        String errorMsg = "Type " + type + " cannot be used in logic operation with " + this.getClass().getSimpleName();

        return BinaryOperationCheck(type, node, errorMsg);
    }

    @Override
    public Type comparison(Type type, ASTNode node) {
        String errorMsg = "Cannot compare type " + type + " with " + this.getClass().getSimpleName();

        return BinaryOperationCheck(type, node, errorMsg);
    }

    private Type BinaryOperationCheck(Type type, ASTNode node, String errorMsg) {
        if (type instanceof RealType)
            return IntType.getInstance();
        if (type instanceof IntType)
            return IntType.getInstance();
        if (type instanceof CharType)
            return IntType.getInstance();
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(errorMsg, node);
    }

    @Override
    public Type promote(Type type, ASTNode node) {
        String errorMsg = this + " cannot be passed as " + type;
        return typeInference(type, node, errorMsg);
    }
}

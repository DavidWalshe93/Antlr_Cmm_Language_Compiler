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

    @Override
    public Type arithmetic(Type type, ASTNode node) {
        String errorMsg = "Type " + type + " cannot be used in arithmetic operations with IntType";
        return implicitCasting(type, node, errorMsg);
    }

    @Override
    public Type returns(Type type, ASTNode node) {
        if (type instanceof VoidType) {
            return new ErrorType("Cannot return '" + this.getClass().getSimpleName() + "' if void is specified as the return type in function signature", node);
        }
        String errorMsg = "Cannot return '" + this.getClass().getSimpleName() + "' for function return signature of type '" + type + "'";
        return implicitCasting(type, node, errorMsg);
    }


    abstract Type implicitCasting(Type type, ASTNode node, String errorMsg);

}

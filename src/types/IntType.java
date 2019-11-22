/**
 * Internal representation of "int" type in the source language.
 *
 * @author Francisco Ortin
 */

package types;

import ast.ASTNode;
import visitor.Visitor;

public class IntType extends PrimitiveType {

    private static IntType instance = new IntType();

    public IntType(int line, int column) {
        super(line, column);
    }

    private IntType() {
        super(0, 0);
    }

    public static IntType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type implicitCasting(Type type, ASTNode node, String errorMsg) {
        if (type instanceof RealType)
            return RealType.getInstance();
        if (type instanceof IntType)
            return this;
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(errorMsg, node);
    }
}

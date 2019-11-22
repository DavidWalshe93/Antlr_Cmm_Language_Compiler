package types;

import ast.ASTNode;
import visitor.Visitor;

/**
 * Author: David Walshe
 * Date: 08/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class CharType extends PrimitiveType {

    private static CharType instance = new CharType();

    public CharType(int line, int column) {
        super(line, column);
    }

    private CharType() {
        super(0, 0);
    }

    public static CharType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "char";
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
            return IntType.getInstance();
        if (type instanceof CharType)
            return this;
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(errorMsg, node);
    }
}

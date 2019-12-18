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

    /**
     * Semantic Analysis
     **/

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(Type type, ASTNode node) {
        // CHECK 2) [type-checking] is this implementation correct for type promotion
        String errorMsg = "Type " + this + " cannot be used in arithmetic operation with " + type;

        if (type instanceof RealType)
            return RealType.getInstance();
        if (type instanceof IntType)
            return IntType.getInstance();
        if (type instanceof CharType)
            // todo - change to inttype
            return IntType.getInstance();
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(errorMsg, node);
    }

    @Override
    public Type typePromotion(Type type, ASTNode node, String errorMsg) {
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

    /**
     * Code Generation
     **/
    @Override
    public int numberOfBytes() {
        return 1;
    }

	@Override
	public char suffix() {
		return 'b';
	}

	@Override
	public String convertTo(Type conversionType) {
		if (conversionType instanceof CharType)
			return "";
		if (conversionType instanceof RealType)
			return "b2i\n\ti2f";
		if (conversionType instanceof IntType)
			return "b2i";
		throw new IllegalArgumentException("Conversion is not possible between " + this + " and " + conversionType);
	}
}

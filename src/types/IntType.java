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
            return this;
        if (type instanceof CharType)
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
        return 2;
    }

	@Override
	public char suffix() {
		return 'i';
	}

	@Override
	public String convertTo(Type conversionType) {
		if (conversionType instanceof IntType)
			return "";
		if (conversionType instanceof RealType)
			return "i2f";
		if (conversionType instanceof CharType)
			return "i2b";
		throw new IllegalArgumentException("Conversion is not possible between " + this + " and " + conversionType);
	}
}

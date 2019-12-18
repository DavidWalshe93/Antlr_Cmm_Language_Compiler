/**
 * Internal representation of "double" type in the source language.
 *
 * @author Francisco Ortin
 */

package types;

import ast.ASTNode;
import visitor.Visitor;

public class RealType extends PrimitiveType {

    private static RealType instance = new RealType();

    public RealType(int line, int column) {
        super(line, column);
    }

    private RealType() {
        super(0, 0);
    }

    public static RealType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "double";
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
            return this;
        if (type instanceof IntType)
            return RealType.getInstance();
        if (type instanceof CharType)
            return RealType.getInstance();
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(errorMsg, node);
    }

    @Override
    public Type typePromotion(Type type, ASTNode node, String errorMsg) {
        if (type instanceof RealType)
            return RealType.getInstance();
        if (type instanceof ErrorType)
            return type;
        return new ErrorType(errorMsg, node);
    }

    /**
     * Code Generation
     **/

    @Override
    public int numberOfBytes() {
        return 4;
    }

	@Override
	public char suffix() {
		return 'f';
	}

	@Override
	public String convertTo(Type conversionType) {
		if (conversionType instanceof RealType)
			return "";
		if (conversionType instanceof IntType)
			return "f2i";
		if (conversionType instanceof CharType)
			return "f2i\n\ti2b";
		throw new IllegalArgumentException("Conversion is not possible between " + this + " and " + conversionType);
	}
}

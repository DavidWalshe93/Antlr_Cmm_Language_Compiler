package ast.expressions;

import types.CharType;
import visitor.Visitor;

/**
 * Author: David Walshe
 * Date: 18/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class CharLiteral extends AbstractExpression {

    private char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
        this.setType(CharType.getInstance());
    }

	public char getValue() {
		return value;
	}

    @Override
    public String toString() {
        return "'" + value + "'";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

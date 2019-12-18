/**
 * AST node for integer literals.
 *
 * @author Francisco Ortin
 */

package ast.expressions;

import types.IntType;
import visitor.Visitor;

public class IntLiteral extends AbstractExpression {

    private int value;

    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
        this.setType(IntType.getInstance());
    }

	public int getValue() {
		return value;
	}

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

/**
 * AST node for real literals.
 *
 * @author Francisco Ortin
 */

package ast.expressions;

public class RealLiteral extends AbstractExpression {

    private double value;

    public RealLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

}

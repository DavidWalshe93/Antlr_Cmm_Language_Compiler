/**
 * AST node for write statements.
 *
 * @author Francisco Ortin
 */

package ast.statements;


import ast.AbstractASTNode;
import ast.expressions.Expression;

public class Write extends AbstractASTNode implements Statement {

    /**
     * Expression to be written
     */
    private Expression expression;

    public Write(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "write " + expression + ";";
    }


}

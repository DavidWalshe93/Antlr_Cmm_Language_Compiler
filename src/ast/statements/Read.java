package ast.statements;

import ast.AbstractASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

/**
 * Developer: David Walshe
 * Date: 03/10/2019
 */
public class Read extends AbstractASTNode implements Statement {

    /**
     * Expression to be read
     */
    private Expression expression;

    public Read(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "read " + expression + ";";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}

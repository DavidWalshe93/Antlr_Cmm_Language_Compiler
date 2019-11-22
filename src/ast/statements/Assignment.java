/**
 * AST node for assignment statements.
 *
 * @author Francisco Ortin
 */

package ast.statements;

import ast.AbstractASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

public class Assignment extends AbstractASTNode implements Statement {

    private Expression leftHandSide;
    private Expression rightHandSide;
    private Boolean lvalue;

    public Assignment(int line, int column, Expression lhs, Expression rhs) {
        super(line, column);
        this.leftHandSide = lhs;
        this.rightHandSide = rhs;
    }

    public Expression getLeftHandSide() {
        return this.leftHandSide;
    }

    public Expression getRightHandSide() {
        return this.rightHandSide;
    }

    public Boolean getLvalue() {
        return this.lvalue;
    }

    public void setLvalue(Boolean lvalue) {
        this.lvalue = lvalue;
    }

    @Override
    public String toString() {
        return "" + leftHandSide + " = " + rightHandSide;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

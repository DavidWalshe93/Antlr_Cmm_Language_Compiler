package ast.expressions;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class StructAccess extends AbstractExpression {

    private Expression parentNode;
    private Expression childNode;

    public StructAccess(int line, int column, Expression parentNode, Expression childNode) {
        super(line, column);
        this.parentNode = parentNode;
        this.childNode = childNode;
    }

    public Expression getParentNode() {
        return parentNode;
    }

    public Expression getChildNode() {
        return childNode;
    }

    @Override
    public String toString() {
        return this.getParentNode().toString() + "." + this.getChildNode().toString();
    }
}

package ast.expressions;

import visitor.Visitor;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Comparison extends AbstractBinaryExpression {

    public Comparison(int line, int column, Expression operand1, String operator, Expression operand2) {
        super(line, column, operand1, operator, operand2);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

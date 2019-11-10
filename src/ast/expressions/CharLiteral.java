package ast.expressions;

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
    }

    @Override
    public String toString() {
        int r = (int) value;
        return "'" + value + "'";

    }

}

/**
 * Internal representation of "int" type in the source language.
 *
 * @author Francisco Ortin
 */

package types;

import visitor.Visitor;

public class IntType extends AbstractType {

    private static IntType instance = new IntType();

    public IntType(int line, int column) {
        super(line, column);
    }

    private IntType() {
        super(0, 0);
    }

    public static IntType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

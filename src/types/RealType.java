/**
 * Internal representation of "double" type in the source language.
 *
 * @author Francisco Ortin
 */

package types;

import visitor.Visitor;

public class RealType extends AbstractType {

    private static RealType instance = new RealType();

    public RealType(int line, int column) {
        super(line, column);
    }

    private RealType() {
        super(0, 0);
    }

    public static RealType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "double";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

/**
 * Internal representation of "double" type in the source language.
 *
 * @author Francisco Ortin
 */

package types;

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

}

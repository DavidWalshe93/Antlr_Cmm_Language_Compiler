/**
 * Internal representation of "int" type in the source language.
 *
 * @author Francisco Ortin
 */

package types;

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

}

package types;

/**
 * Author: David Walshe
 * Date: 08/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class CharType extends AbstractType {

    private static CharType instance = new CharType();

    public CharType(int line, int column) {
        super(line, column);
    }

    private CharType() {
        super(0, 0);
    }

    public static CharType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "char";
    }
}

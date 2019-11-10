package types;

/**
 * Author: David Walshe
 * Date: 05/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class VoidType extends AbstractType {

    private static VoidType instance = new VoidType();

    private VoidType() {
        super(0, 0);
    }

    public static VoidType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "void";
    }
}

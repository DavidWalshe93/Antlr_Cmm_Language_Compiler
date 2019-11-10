package types;

/**
 * Author: David Walshe
 * Date: 08/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class StructType extends AbstractType {


    private static StructType instance = new StructType();

    private StructType() {
        super(0, 0);
    }

    public static StructType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "struct";
    }
}

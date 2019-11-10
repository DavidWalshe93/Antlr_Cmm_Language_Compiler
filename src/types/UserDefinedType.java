package types;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class UserDefinedType extends AbstractType {

    private Type type;

    public UserDefinedType(int line, int column, Type type) {
        super(line, column);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.getType() + "";
    }
}

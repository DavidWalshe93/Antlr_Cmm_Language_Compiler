package types;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class UserDefinedType extends AbstractType {

    private String type;

    public UserDefinedType(int line, int column, String type) {
        super(line, column);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "type " + this.getType();
    }
}

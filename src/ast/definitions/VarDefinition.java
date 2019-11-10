/**
 * AST node representing the definition of a global variable.
 *
 * @author Francisco Ortin
 */

package ast.definitions;

import ast.statements.Statement;
import types.Type;

public class VarDefinition extends AbstractDefinition implements Statement {

    /**
     * The offset of the variable
     */
    private int offset;

    public VarDefinition(int line, int column, String name, Type type) {
        super(line, column, name, type);
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getType(), this.getName());
    }
}	
	


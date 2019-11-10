/**
 * AST node for variables (identifiers).
 *
 * @author Francisco Ortin
 */

package ast.expressions;

import ast.definitions.VarDefinition;

public class Variable extends AbstractExpression {

    private String name;
    private VarDefinition definition;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public VarDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(VarDefinition definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return name;
    }


}

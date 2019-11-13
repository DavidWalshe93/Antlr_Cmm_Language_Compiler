/**
 * AST node for variables (identifiers).
 *
 * @author Francisco Ortin
 */

package ast.expressions;

import ast.definitions.VariableDefinition;
import visitor.Visitor;

public class Variable extends AbstractExpression {

    private String name;
    private VariableDefinition definition;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public VariableDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(VariableDefinition definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

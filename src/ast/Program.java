/**
 * AST node representing a program: a colleciton of variable definitions followed by a
 * collection of statements.
 *
 * @author Francisco Ortin
 */

package ast;

import ast.definitions.Definition;
import visitor.Visitor;

import java.util.List;

public class Program extends AbstractASTNode {

    /**
     * Global variables
     */
    private List<Definition> definitions;
    /**
     * statements in the main function
     */

    public Program(int line, int column, List<Definition> definitions) {
        super(line, column);
        this.definitions = definitions;
    }

    public List<Definition> getDefinitions() {
        return this.definitions;
    }


    @Override
    public String toString() {
        return String.format("Program with %d definitions",
                this.definitions.size());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

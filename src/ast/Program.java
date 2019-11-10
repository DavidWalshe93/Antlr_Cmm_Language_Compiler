/**
 * AST node representing a program: a colleciton of variable definitions followed by a
 * collection of statements.
 *
 * @author Francisco Ortin
 */

package ast;

import ast.definitions.Definition;
import ast.statements.Statement;

import java.util.List;

public class Program extends AbstractASTNode {

    /**
     * Global variables
     */
    private List<Definition> definitions;
    /**
     * statements in the main function
     */
    private List<Statement> statements;

    public Program(int line, int column, List<Definition> definitions, List<Statement> statements) {
        super(line, column);
        this.definitions = definitions;
        this.statements = statements;
    }

    public List<Definition> getDefinitions() {
        return this.definitions;
    }

    public List<Statement> getStatements() {
        return this.statements;
    }

    @Override
    public String toString() {
        return String.format("Program with %d definitions and %d statements.",
                this.definitions.size(), this.statements.size());
    }

}

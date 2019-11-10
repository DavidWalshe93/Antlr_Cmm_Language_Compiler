/**
 * Generic type for any AST node. Any node should provide its line and colmun in the source program.
 *
 * @author Francisco Ortin
 * @see The default implementation in AbstractASTNode
 */

package ast;

public interface ASTNode {
    /**
     * Number of line and column where the node appears in the source code
     */
    int getLine();

    int getColumn();
}


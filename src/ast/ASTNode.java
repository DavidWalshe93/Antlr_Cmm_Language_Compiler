/**
 * Generic type for any AST node. Any node should provide its line and colmun in the source program.
 *
 * @author Francisco Ortin
 * @see The default implementation in AbstractASTNode
 */

package ast;

import visitor.Visitor;

public interface ASTNode {
    /**
     * Number of line and column where the node appears in the source code
     */
    int getLine();

    int getColumn();

    <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param);
}


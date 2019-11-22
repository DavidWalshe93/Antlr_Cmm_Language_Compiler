/**
 * General type for expressions.
 *
 * @author Francisco Ortin
 * @see The default implementation in the AbstractExpression class
 */

package ast.expressions;

import ast.ASTNode;
import types.Type;
import visitor.Visitor;


public interface Expression extends ASTNode {

    /**
     * The type of the expressions
     */
    Type getType();

    void setType(Type type);

    Boolean getLvalue();

    void setLvalue(boolean lvalue);

    <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param);

}

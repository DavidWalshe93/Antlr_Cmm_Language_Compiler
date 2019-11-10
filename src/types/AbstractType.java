/**
 * Default implementation of Type.
 *
 * @author Francisco Ortin
 */

package types;


import ast.AbstractASTNode;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

}

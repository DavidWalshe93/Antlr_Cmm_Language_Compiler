/**
 * This type generalizes any type in the compiler.
 * Besides representing types, they also hold responsibilities of semantic analysis and code generation.
 *
 * @author Francisco Ortin
 * @see AbstractType for the default implementation.
 */

package types;


import ast.ASTNode;

public interface Type extends ASTNode {

}

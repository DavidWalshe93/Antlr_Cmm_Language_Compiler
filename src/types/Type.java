/**
 * This type generalizes any type in the compiler.
 * Besides representing types, they also hold responsibilities of semantic analysis and code generation.
 *
 * @author Francisco Ortin
 * @see AbstractType for the default implementation.
 */

package types;


import ast.ASTNode;

import java.util.ArrayList;

public interface Type extends ASTNode {

    /******** Semantic analysis ***************/

    Type arithmetic(Type type, ASTNode astNode);

    Type assignment(Type type, ASTNode astNode);

    Type squareBrackets(Type type, ASTNode astNode);

    Type dot(String type, ASTNode astNode);

    Type parenthesis(ArrayList<Type> invocationTypes, ASTNode astNode);

    Type returns(Type returnType, ASTNode astNode);

    Type comparison(Type type, ASTNode astNode);

    Type logic(Type type, ASTNode astNode);

    Type promote(Type type, ASTNode astNode);

    /**
     * Code Generation
     **/

    int numberOfBytes();

}

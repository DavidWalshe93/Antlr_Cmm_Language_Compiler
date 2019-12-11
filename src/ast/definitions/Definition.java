package ast.definitions;

import ast.ASTNode;
import types.Type;

/**
 * Developer: David Walshe
 * Date: 03/10/2019
 */
public interface Definition extends ASTNode {

    String getName();

    void setType(Type type);

    Type getType();

    int getScope();

    void setScope(int scope);

}

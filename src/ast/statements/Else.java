package ast.statements;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 20/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Else extends Conditional implements Statement {

    public Else(int line, int column, ArrayList<Statement> statements) {
        super(line, column, null, statements);
    }

    @Override
    public String toString() {
        return "else{" + this.getStatementsAsString() + "}\n";
    }
}

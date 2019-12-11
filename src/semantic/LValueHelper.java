package semantic;

import ast.expressions.Dot;
import ast.expressions.Indexing;
import ast.expressions.Variable;
import ast.statements.Assignment;
import ast.statements.Read;
import types.ErrorType;

/**
 * Author: David Walshe
 * Date: 25/11/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class LValueHelper {

    public void calculateLValue(Assignment assignment) {
        assignment.setLvalue(assignment.getLeftHandSide().getLvalue());
        if (!assignment.getLvalue()) {
            new ErrorType("lvalue required", assignment);
        }
    }

    public void calculateLValue(Read read) {
        read.setLvalue(read.getExpression().getLvalue());
        if (!read.getLvalue()) {
            new ErrorType("lvalue required", read);
        }
    }

    public void calculateLValue(Indexing indexing) {
        indexing.setLvalue(true);
    }

    public void calculateLValue(Variable variable) {
        variable.setLvalue(true);
    }

    public void calculatLValue(Dot dot) {
        dot.setLvalue(true);
    }

}

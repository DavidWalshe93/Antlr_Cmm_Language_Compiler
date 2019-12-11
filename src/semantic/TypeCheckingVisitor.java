package semantic;

import ast.definitions.FunctionDefinition;
import ast.expressions.*;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.Statement;
import types.ArrayType;
import types.ErrorType;
import types.FunctionType;
import types.Type;
import visitor.AbstractVisitor;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 13/11/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

// lvalue = dot, variable, indexing
public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {

    private LValueHelper lValueHelper = new LValueHelper(); // Helper class for lvalue assignments

    @Override
    public Void visit(Assignment assignment, Type param) {
        super.visit(assignment, param);
        this.lValueHelper.calculateLValue(assignment);

        assignment.getRightHandSide().getType().assignment(assignment.getLeftHandSide().getType(), assignment);

        return null;
    }

    @Override
    public Void visit(Read read, Type param) {
        super.visit(read, param);
        this.lValueHelper.calculateLValue(read);

        return null;
    }

    @Override
    public Void visit(Indexing indexing, Type param) {
        super.visit(indexing, param);
        this.lValueHelper.calculateLValue(indexing);
        if (indexing.getExpression().getType() instanceof ArrayType) {
            indexing.getExpression().getType().squareBrackets(indexing.getArrayIndex().getType(), indexing);
            indexing.setType(((ArrayType) indexing.getExpression().getType()).getType());
        } else {
            indexing.setType(new ErrorType(indexing.getExpression() + " is not an array", indexing));
        }

        return null;
    }

    @Override
    public Void visit(Variable variable, Type param) {
        super.visit(variable, param);
        this.lValueHelper.calculateLValue(variable);

        if (variable.getType() instanceof FunctionType) {
            new ErrorType("Cannot use function alias without invocation '()'", variable);
        }

        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Type param) {
        super.visit(arithmetic, param);

        arithmetic.setType(arithmetic.getOperand1().getType().arithmetic(arithmetic.getOperand2().getType(), arithmetic));

        return null;
    }

    @Override
    public Void visit(FunctionExpression functionExpression, Type param) {
        // CHECK - 1) [type-checking] Implementation correct for functionExpression
        super.visit(functionExpression, param);

        ArrayList<Type> invocationTypes = new ArrayList<>();
        functionExpression.getParameters().forEach((parameter) -> invocationTypes.add(parameter.getType()));

        functionExpression.setType(functionExpression.getDefinition().getType().parenthesis(invocationTypes, functionExpression));

        return null;
    }

    @Override
    public Void visit(Dot dot, Type param) {
        super.visit(dot, param);
        this.lValueHelper.calculatLValue(dot);

        // CHECK - 3) [type-checking] Check if dot implementation is correct.
        dot.setType(dot.getRecord().getType().dot(dot.getFieldName(), dot));
        return null;
    }

    @Override
    public Void visit(Logic logic, Type param) {
        super.visit(logic, param);
        logic.setType(logic.getOperand1().getType().logic(logic.getOperand2().getType(), logic));

        return null;
    }

    @Override
    public Void visit(Comparison comparison, Type param) {
        super.visit(comparison, param);
        comparison.setType(comparison.getOperand1().getType().comparison(comparison.getOperand2().getType(), comparison));

        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Type param) {
        super.visit(functionDefinition, param);

        for (Statement statement : functionDefinition.getBody()) {
            if (statement instanceof Return) {
                Type returnStatementType = ((Return) statement).getExpression().getType();
                returnStatementType.returns(functionDefinition.getReturnType(), functionDefinition);
            }
        }
        return null;
    }

}

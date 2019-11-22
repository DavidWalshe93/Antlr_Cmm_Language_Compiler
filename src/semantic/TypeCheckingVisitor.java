package semantic;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.expressions.*;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.Statement;
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

    @Override
    public Void visit(Arithmetic arithmetic, Type param) {
        arithmetic.getOperand1().accept(this, null);
        arithmetic.getOperand2().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Type param) {
        assignment.getLeftHandSide().accept(this, null);
        assignment.getRightHandSide().accept(this, null);
        assignment.setLvalue(assignment.getLeftHandSide().getLvalue());
        if (!assignment.getLvalue()) {
            new ErrorType("Cannot assign value to " + assignment.getLeftHandSide().getClass().getSimpleName() + ": " + assignment.getLeftHandSide(), assignment);
        }
        return null;
    }

    @Override
    public Void visit(Read read, Type param) {
        read.getExpression().accept(this, null);
        read.setLvalue(read.getExpression().getLvalue());
        if (!read.getLvalue()) {
            new ErrorType("Cannot use read with type " + read.getExpression().getClass().getSimpleName() + ": " + read.getExpression(), read);
        }
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Type param) {
        indexing.getArrayIndex().accept(this, null);
        indexing.getExpression().accept(this, null);
        indexing.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Variable variable, Type param) {
        variable.getDefinition().accept(this, null);
        variable.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Dot dot, Type param) {
        dot.getRecord().accept(this, null);
        dot.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FunctionExpression functionExpression, Type param) {
        ArrayList<Type> types = new ArrayList<>();
        for (Expression expression : functionExpression.getParameters()) {
            expression.accept(this, null);
            types.add(expression.getType());
        }
        functionExpression.getDefinition().getType().parenthesis(types, functionExpression);
        return null;
    }

    @Override
    public Void visit(Return _return, Type param) {
        _return.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Type param) {
        for (Definition parameter : functionType.getParameters()) {
            parameter.accept(this, null);
        }
        functionType.getReturnType().accept(this, null);

        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Type param) {
        functionDefinition.getType().accept(this, null);

        for (Statement statement : functionDefinition.getBody()) {
            statement.accept(this, functionDefinition.getReturnType());
            if (statement instanceof Return) {
                Type returnStatementType = ((Return) statement).getExpression().getType();
                functionDefinition.getType().returns(returnStatementType, functionDefinition);
            }
        }

        return null;
    }
}

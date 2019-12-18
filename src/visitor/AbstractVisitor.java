package visitor;

import ast.Program;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import types.*;

/**
 * Author: David Walshe
 * Date: 13/11/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

    // -------------- Program -----------------

    @Override
    public TR visit(Program program, TP param) {
        program.getDefinitions().forEach((definition) -> definition.accept(this, param));
        return null;
    }

    // -------------- Definitions --------------------------------------------------------------------------------------

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP param) {
        functionDefinition.getType().accept(this, param);
        functionDefinition.getBody().forEach((stmt) -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(StructDefinition structDefinition, TP param) {
        structDefinition.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(TypeDefinition typeDefinition, TP param) {
        typeDefinition.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP param) {
        variableDefinition.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(RecordDefinition recordDefinition, TP param) {
        recordDefinition.getType().accept(this, param);
        return null;
    }

    // -------------- Expressions --------------------------------------------------------------------------------------

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.getOperand1().accept(this, param);
        arithmetic.getOperand2().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        cast.getExpression().accept(this, param);
        cast.getCastType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        charLiteral.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        intLiteral.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        realLiteral.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        comparison.getOperand1().accept(this, param);
        comparison.getOperand2().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FunctionExpression functionExpression, TP param) {
        functionExpression.getParameters().forEach((parameter) -> parameter.accept(this, param));

        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        indexing.getArrayIndex().accept(this, param);
        indexing.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Logic logic, TP param) {
        logic.getOperand1().accept(this, param);
        logic.getOperand2().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Not not, TP param) {
        not.getOperand().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Dot dot, TP param) {
        dot.getRecord().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        variable.getType().accept(this, param);
        variable.getDefinition().accept(this, param);
        return null;
    }

    // -------------- Statements ---------------------------------------------------------------------------------------

    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.getLeftHandSide().accept(this, param);
        assignment.getRightHandSide().accept(this, param);
        return null;
    }

    @Override
    public TR visit(If _if, TP param) {
        _if.getCondition().accept(this, param);
        _if.getStatements().forEach((stmt) -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Else _else, TP param) {
        _else.getStatements().forEach((stmt) -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        read.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Return _return, TP param) {
        _return.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(While _while, TP param) {
        _while.getCondition().accept(this, param);
        _while.getStatements().forEach((stmt) -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Write write, TP param) {
        write.getExpression().accept(this, param);
        return null;
    }

    // -------------- Types --------------------------------------------------------------------------------------------

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        arrayType.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        functionType.getParameters().forEach((parameter) -> parameter.accept(this, param));
        functionType.getReturnType().accept(this, param);

        return null;
    }

    @Override
    public TR visit(IntType intType, TP param) {
        return null;
    }

    @Override
    public TR visit(RealType realType, TP param) {
        return null;
    }

    @Override
    public TR visit(StructType structType, TP param) {
        structType.getRecordFields().forEach((k, recordField) -> recordField.accept(this, param));
        return null;
    }

    @Override
    public TR visit(UserDefinedType userDefinedType, TP param) {
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }
}

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
        for (Definition definition : program.getDefinitions()) {
            definition.accept(this, param);
        }
        return null;
    }

    // -------------- Definitions --------------------------------------------------------------------------------------

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP param) {
        for (Statement stmt : functionDefinition.getBody())
            stmt.accept(this, param);
        return null;
    }

    @Override
    public TR visit(StructDefinition structDefinition, TP param) {
//        structDefinition. .accept(this, param);
        return null;
    }

    @Override
    public TR visit(TypeDefinition typeDefinition, TP param) {
//        typeDefinition.accept(this, param);
        return null;
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP param) {
        variableDefinition.getType().accept(this, param);
        return null;
    }

    // -------------- Expressions --------------------------------------------------------------------------------------

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionExpression functionExpression, TP param) {
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Logic logic, TP param) {
        return null;
    }

    @Override
    public TR visit(Not not, TP param) {
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Dot dot, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    // -------------- Statements ---------------------------------------------------------------------------------------

    @Override
    public TR visit(Assignment assignment, TP param) {
        System.out.println("assignment");
        assignment.getLeftHandSide().accept(this, param);
        assignment.getRightHandSide().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Else _else, TP param) {
        return null;
    }

    @Override
    public TR visit(If _if, TP param) {
        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        read.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Return _return, TP param) {
        return null;
    }

    @Override
    public TR visit(While _while, TP param) {
        return null;
    }

    @Override
    public TR visit(Write write, TP param) {
        return null;
    }

    // -------------- Types --------------------------------------------------------------------------------------------

    @Override
    public TR visit(ArrayType arrayType, TP param) {
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

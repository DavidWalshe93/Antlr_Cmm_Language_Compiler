package visitor;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.StructDefinition;
import ast.definitions.TypeDefinition;
import ast.definitions.VariableDefinition;
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

public interface Visitor<TP, TR> {

    // -------------- Program ------------------------------------------------------------------------------------------

    TR visit(Program program, TP param);

    // -------------- Definitions --------------------------------------------------------------------------------------

    TR visit(FunctionDefinition functionDefinition, TP param);

    TR visit(StructDefinition structDefinition, TP param);

    TR visit(TypeDefinition typeDefinition, TP param);

    TR visit(VariableDefinition variableDefinition, TP param);

    // -------------- Expressions --------------------------------------------------------------------------------------

    TR visit(Arithmetic arithmetic, TP param);

    TR visit(Cast cast, TP param);

    TR visit(CharLiteral charLiteral, TP param);

    TR visit(Comparison comparison, TP param);

    TR visit(FunctionExpression functionExpression, TP param);

    TR visit(Indexing indexing, TP param);

    TR visit(IntLiteral intLiteral, TP param);

    TR visit(Logic logic, TP param);

    TR visit(Not not, TP param);

    TR visit(RealLiteral realLiteral, TP param);

    TR visit(StructAccess structAccess, TP param);

    TR visit(UnaryMinus unaryMinus, TP param);

    TR visit(Variable variable, TP param);

    // -------------- Statements ---------------------------------------------------------------------------------------

    TR visit(Assignment assignment, TP param);

    TR visit(Else _else, TP param);

    TR visit(If _if, TP param);

    TR visit(Read read, TP param);

    TR visit(Return _return, TP param);

    TR visit(While _while, TP param);

    TR visit(Write write, TP param);

    // -------------- Types --------------------------------------------------------------------------------------------

    TR visit(ArrayType arrayType, TP param);

    TR visit(CharType charType, TP param);

    TR visit(ErrorType errorType, TP param);

    TR visit(FunctionType functionType, TP param);

    TR visit(IntType intType, TP param);

    TR visit(RealType realType, TP param);

    TR visit(StructType structType, TP param);

    TR visit(UserDefinedType userDefinedType, TP param);

    TR visit(VoidType voidType, TP param);

}

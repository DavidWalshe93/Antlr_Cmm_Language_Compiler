package codegeneration.cg;

import ast.Program;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import types.*;
import visitor.Visitor;

/**
 * Author: David Walshe
 * Date: 15/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public abstract class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

	protected CodeGenerator codeGenerator;

	public AbstractCGVisitor(CodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
	}

	public CodeGenerator getCodeGenerator() {
		return codeGenerator;
	}

	@Override
	public TR visit(Program program, TP param) {
		throw new IllegalStateException("Code generation template \"" + program.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(FunctionDefinition functionDefinition, TP param) {
		throw new IllegalStateException("Code generation template \"" + functionDefinition.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(StructDefinition structDefinition, TP param) {
		throw new IllegalStateException("Code generation template \"" + structDefinition.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(TypeDefinition typeDefinition, TP param) {
		throw new IllegalStateException("Code generation template \"" + typeDefinition.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(VariableDefinition variableDefinition, TP param) {
		throw new IllegalStateException("Code generation template \"" + variableDefinition.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(RecordDefinition variableDefinition, TP param) {
		throw new IllegalStateException("Code generation template \"" + variableDefinition.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Arithmetic arithmetic, TP param) {
		throw new IllegalStateException("Code generation template \"" + arithmetic.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Cast cast, TP param) {
		throw new IllegalStateException("Code generation template \"" + cast.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(CharLiteral charLiteral, TP param) {
		throw new IllegalStateException("Code generation template \"" + charLiteral.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Comparison comparison, TP param) {
		throw new IllegalStateException("Code generation template \"" + comparison.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(FunctionExpression functionExpression, TP param) {
		throw new IllegalStateException("Code generation template \"" + functionExpression.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Indexing indexing, TP param) {
		throw new IllegalStateException("Code generation template \"" + indexing.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(IntLiteral intLiteral, TP param) {
		throw new IllegalStateException("Code generation template \"" + intLiteral.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Logic logic, TP param) {
		throw new IllegalStateException("Code generation template \"" + logic.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Not not, TP param) {
		throw new IllegalStateException("Code generation template \"" + not.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(RealLiteral realLiteral, TP param) {
		throw new IllegalStateException("Code generation template \"" + realLiteral.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Dot dot, TP param) {
		throw new IllegalStateException("Code generation template \"" + dot.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(UnaryMinus unaryMinus, TP param) {
		throw new IllegalStateException("Code generation template \"" + unaryMinus.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Variable variable, TP param) {
		throw new IllegalStateException("Code generation template \"" + variable.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Assignment assignment, TP param) {
		throw new IllegalStateException("Code generation template \"" + assignment.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Else _else, TP param) {
		throw new IllegalStateException("Code generation template \"" + _else.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(If _if, TP param) {
		throw new IllegalStateException("Code generation template \"" + _if.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Read read, TP param) {
		throw new IllegalStateException("Code generation template \"" + read.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Return _return, TP param) {
		throw new IllegalStateException("Code generation template \"" + _return.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(While _while, TP param) {
		throw new IllegalStateException("Code generation template \"" + _while.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Write write, TP param) {
		throw new IllegalStateException("Code generation template \"" + write.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(ArrayType arrayType, TP param) {
		throw new IllegalStateException("Code generation template \"" + arrayType.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(CharType charType, TP param) {
		throw new IllegalStateException("Code generation template \"" + charType.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(ErrorType errorType, TP param) {
		throw new IllegalStateException("Code generation template \"" + errorType.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(FunctionType functionType, TP param) {
		throw new IllegalStateException("Code generation template \"" + functionType.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(IntType intType, TP param) {
		throw new IllegalStateException("Code generation template \"" + intType.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(RealType realType, TP param) {
		throw new IllegalStateException("Code generation template \"" + realType.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(StructType structType, TP param) {
		throw new IllegalStateException("Code generation template \"" + structType.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(UserDefinedType userDefinedType, TP param) {
		throw new IllegalStateException("Code generation template \"" + userDefinedType.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(VoidType voidType, TP param) {
		throw new IllegalStateException("Code generation template \"" + voidType.getClass().getSimpleName() + "\" " +
				"not defined for the code function " + this.getClass().getName());
	}
}

package codegeneration.cg;

import ast.Program;
import ast.definitions.*;
import ast.expressions.FunctionExpression;
import ast.statements.*;
import codegeneration.ReturnInformation;
import types.*;

/**
 * Author: David Walshe
 * Date: 15/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */


// todo - TP - RetBytes
public class ExecuteCGVisitor extends AbstractCGVisitor<ReturnInformation, Void> {

	private AddressCGVisitor addressCGVisitor;

	private ValueCGVisitor valueCGVisitor;

	public ExecuteCGVisitor(CodeGenerator codeGenerator) {
		super(codeGenerator);
		this.valueCGVisitor = new ValueCGVisitor(codeGenerator);
		this.addressCGVisitor = new AddressCGVisitor(codeGenerator, valueCGVisitor);
	}

	@Override
	public Void visit(Program program, ReturnInformation returnInfo) {
		this.codeGenerator.commentln("Global variables");
		program.getGlobalVariables().forEach(globalVariable -> {
			globalVariable.accept(this, null);
		});
		codeGenerator.mainCall();
		program.getGlobalDefinitions().forEach(definition -> definition.accept(this, null));

		this.codeGenerator.close();
		return null;
	}

	@Override
	public Void visit(FunctionDefinition functionDefinition, ReturnInformation returnInfo) {
		codeGenerator.line(functionDefinition);
		this.codeGenerator.funcDef(functionDefinition);
		this.codeGenerator.commentln("Parameters:");
		((FunctionType) functionDefinition.getType()).getParameters().forEach(parameter -> {
			parameter.accept(this, null);
		});
		this.codeGenerator.commentln("Local variables:");
		functionDefinition.getLocalVariables().forEach(localVariable -> localVariable.accept(this, null));
		this.codeGenerator.enter(functionDefinition.getLocalsByteSize());
		ReturnInformation returnInformation = new ReturnInformation(functionDefinition.getReturnByteSize(),
				functionDefinition.getLocalsByteSize(),
				functionDefinition.getParametersByteSize(),
				functionDefinition.getReturnType());
		functionDefinition.getStatements().forEach(statement -> {
			codeGenerator.line(statement);
			statement.accept(this, returnInformation);
		});
		if (functionDefinition.getReturnType() instanceof VoidType)
			this.codeGenerator.ret(functionDefinition.getReturnByteSize(),
					functionDefinition.getLocalsByteSize(),
					functionDefinition.getParametersByteSize());

		return null;
	}

	@Override
	public Void visit(TypeDefinition typeDefinition, ReturnInformation returnInformation) {
		this.codeGenerator.comment("");
		typeDefinition.getType().accept(this, returnInformation);
		this.codeGenerator.typeDef(typeDefinition);
		return null;
	}

	@Override
	public Void visit(StructDefinition structDefinition, ReturnInformation returnInfo) {
		this.codeGenerator.comment("");
		structDefinition.getType().accept(this, null);
		this.codeGenerator.structDef(structDefinition);
		return null;
	}

	public Void visit(StructType structType, ReturnInformation returnInfo) {
		this.codeGenerator.print("record(");
		for (int i = 0; i < structType.getRecordSequence().size(); i++) {
			structType.getRecordField(structType.getRecordSequence().get(i)).accept(this, null);
			if (i < structType.getRecordSequence().size() - 1) {
				this.codeGenerator.print("x");
			}
		}
		this.codeGenerator.print(")");
		return null;
	}

	@Override
	public Void visit(RecordDefinition recordDefinition, ReturnInformation returnInfo) {
		this.codeGenerator.print("(");
		this.codeGenerator.recordDef(recordDefinition);
		this.codeGenerator.print(" x ");
		recordDefinition.getType().accept(this, returnInfo);
		this.codeGenerator.print(")");

		return null;
	}

	@Override
	public Void visit(VariableDefinition variableDefinition, ReturnInformation returnInfo) {
		codeGenerator.comment("");
		variableDefinition.getType().accept(this, null);
		this.codeGenerator.varDef(variableDefinition);

		return null;
	}

	@Override
	public Void visit(RealType realType, ReturnInformation returnInfo) {
		this.codeGenerator.type(realType);
		return null;
	}

	@Override
	public Void visit(IntType intType, ReturnInformation returnInfo) {
		this.codeGenerator.type(intType);
		return null;
	}

	@Override
	public Void visit(CharType realType, ReturnInformation returnInfo) {
		this.codeGenerator.type(realType);
		return null;
	}

	@Override
	public Void visit(ArrayType arrayType, ReturnInformation returnInfo) {
		this.codeGenerator.arrayNotationBegin(arrayType);
		arrayType.getType().accept(this, null);
		this.codeGenerator.arrayNotationEnd(arrayType);
		return null;
	}

	@Override
	public Void visit(Assignment assignment, ReturnInformation returnInfo) {
		codeGenerator.commentln("Assignment");
		assignment.getLeftHandSide().accept(this.addressCGVisitor, null);
		assignment.getRightHandSide().accept(this.valueCGVisitor, null);
		this.codeGenerator.cast(assignment.getRightHandSide().getType().convertTo(assignment.getLeftHandSide().getType()));
		this.codeGenerator.store(assignment.getLeftHandSide().getType());

		return null;
	}

	@Override
	public Void visit(If _if, ReturnInformation returnInfo) {
		this.codeGenerator.commentln("If Statement");
		this.codeGenerator.commentln("If Conditional");
		_if.getCondition().accept(this.valueCGVisitor, null);
		int label = this.codeGenerator.getLabels(2);
		this.codeGenerator.jz(label);
		this.codeGenerator.commentln("If Body");
		_if.getStatements().forEach(statement -> {
			codeGenerator.line(statement);
			statement.accept(this, null);
		});
		this.codeGenerator.jmp(label + 1);
		this.codeGenerator.label(label);
		if (_if.getElse() != null) {
			_if.getElse().setLabel(label + 1);
		}
		return null;
	}

	@Override
	public Void visit(Else _else, ReturnInformation returnInfo) {
		this.codeGenerator.commentln("Else Body");
		_else.getStatements().forEach(statement -> {
			codeGenerator.line(statement);
			statement.accept(this, null);
		});
		this.codeGenerator.label(_else.getLabel());

		return null;
	}

	@Override
	public Void visit(Return _return, ReturnInformation returnInfo) {
		this.codeGenerator.commentln("Return");
		_return.getExpression().accept(this.valueCGVisitor, null);
		this.codeGenerator.cast(_return.getExpression().getType().convertTo(returnInfo.getReturnType()));
		this.codeGenerator.ret(returnInfo.getReturnByteSize(), returnInfo.getLocalsByteSize(), returnInfo.getParametersByteSize());
		return null;
	}

	@Override
	public Void visit(While _while, ReturnInformation returnInfo) {
		this.codeGenerator.commentln("While Loop");
		int label = this.codeGenerator.getLabels(2);
		this.codeGenerator.label(label);
		this.codeGenerator.commentln("While Conditional");
		_while.getCondition().accept(this.valueCGVisitor, null);
		this.codeGenerator.jz(label + 1);
		this.codeGenerator.commentln("While Body");
		_while.getStatements().forEach(statement -> {
			codeGenerator.line(statement);
			statement.accept(this, null);
		});
		this.codeGenerator.jmp(label);
		this.codeGenerator.label(label + 1);

		return null;
	}

	@Override
	public Void visit(Write write, ReturnInformation returnInfo) {
		codeGenerator.commentln("Write");
		write.getExpression().accept(this.valueCGVisitor, null);
		codeGenerator.output(write.getExpression().getType());
		return null;
	}

	@Override
	public Void visit(Read read, ReturnInformation returnInfo) {
		codeGenerator.commentln("Read");
		read.getExpression().accept(this.addressCGVisitor, null);
		codeGenerator.in(read.getExpression().getType());
		codeGenerator.store(read.getExpression().getType());
		return null;
	}

	@Override
	public Void visit(FunctionExpression functionExpression, ReturnInformation returnInfo) {
		functionExpression.accept(this.valueCGVisitor, null);
		if (!(functionExpression.getType() instanceof VoidType)) {
			this.codeGenerator.pop(functionExpression.getType());
		}
		return null;
	}
}

package codegeneration.cg;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.RecordDefinition;
import ast.definitions.StructDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.*;
import types.*;

/**
 * Author: David Walshe
 * Date: 15/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */


// todo - TP - RetBytes
public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

	private AddressCGVisitor addressCGVisitor;

	private ValueCGVisitor valueCGVisitor;

	public ExecuteCGVisitor(CodeGenerator codeGenerator) {
		super(codeGenerator);
		this.valueCGVisitor = new ValueCGVisitor(codeGenerator);
		this.addressCGVisitor = new AddressCGVisitor(codeGenerator, valueCGVisitor);
	}

	@Override
	public Void visit(Program program, Void param) {
		this.codeGenerator.commentln("Global variables");
		program.getGlobalVariables().forEach(globalVariable -> {
			System.out.println(globalVariable.getClass().getSimpleName());
			globalVariable.accept(this, null);
		});
		codeGenerator.mainCall();
		program.getGlobalDefinitions().forEach(definition -> definition.accept(this, null));
//        program.getDefinitions().forEach(definition -> definition.accept(this, null));
		return null;
	}

	@Override
	public Void visit(FunctionDefinition functionDefinition, Void param) {
		codeGenerator.line(functionDefinition);
		this.codeGenerator.funcDef(functionDefinition);
		this.codeGenerator.commentln("Parameters:");
		((FunctionType) functionDefinition.getType()).getParameters().forEach(parameter -> {
			parameter.accept(this, null);
		});
		this.codeGenerator.commentln("Local variables:");
		functionDefinition.getLocalVariables().forEach(localVariable -> {
			localVariable.accept(this, null);
		});
		this.codeGenerator.enter(functionDefinition.getLocalsByteSize());
		functionDefinition.getStatements().forEach(statement -> {
			statement.accept(this, null);
		});
//        functionDefinition.getBody().forEach(statement -> {
//            statement.accept(this, null);
//        });
		if (functionDefinition.getReturnType() instanceof VoidType)
			this.codeGenerator.ret(functionDefinition.getLocalsByteSize(),
					functionDefinition.getParametersByteSize(),
					functionDefinition.getReturnByteSize());

		return null;
	}

	@Override
	public Void visit(StructDefinition structDefinition, Void param) {
		this.codeGenerator.structDef(structDefinition);
		StructType structType = ((StructType) structDefinition.getType());
		for (int i = 0; i < structType.getRecordFields().size(); i++)
			structType.getRecordFields().get(structType.getRecordSequence().get(i)).accept(this, null);
		return null;
	}

	@Override
	public Void visit(VariableDefinition variableDefinition, Void param) {
		codeGenerator.comment("");
		variableDefinition.getType().accept(this, null);
		this.codeGenerator.varDef(variableDefinition);

		return null;
	}

	@Override
	public Void visit(RecordDefinition recordDefinition, Void param) {
		this.codeGenerator.recordDef(recordDefinition);

		return null;
	}

	@Override
	public Void visit(Assignment assignment, Void param) {
		codeGenerator.line(assignment);
		codeGenerator.commentln("Assignment");
		assignment.getLeftHandSide().accept(this.addressCGVisitor, null);
		assignment.getRightHandSide().accept(this.valueCGVisitor, null);
		this.codeGenerator.store(assignment.getLeftHandSide().getType());

		return null;
	}

	@Override
	public Void visit(Else _else, Void param) {
		return super.visit(_else, param);
	}

	@Override
	public Void visit(If _if, Void param) {
		return super.visit(_if, param);
	}

	@Override
	public Void visit(Return _return, Void param) {
		return super.visit(_return, param);
	}

	@Override
	public Void visit(While _while, Void param) {
		return super.visit(_while, param);
	}

	@Override
	public Void visit(Write write, Void param) {
		codeGenerator.line(write);
		codeGenerator.commentln("Write");
		write.getExpression().accept(this.valueCGVisitor, null);
		codeGenerator.output(write.getExpression().getType());
		return null;
	}

	@Override
	public Void visit(Read read, Void param) {
		codeGenerator.line(read);
		codeGenerator.commentln("Read");
		read.getExpression().accept(this.addressCGVisitor, null);
		codeGenerator.in(read.getExpression().getType());
		codeGenerator.store(read.getExpression().getType());    // CHECK - should be done here or at top level (execute)
		return null;
	}

	@Override
	public Void visit(RealType realType, Void param) {
		this.codeGenerator.type(realType);
		return null;
	}

	@Override
	public Void visit(IntType intType, Void param) {
		this.codeGenerator.type(intType);
		return null;
	}

	@Override
	public Void visit(CharType realType, Void param) {
		this.codeGenerator.type(realType);
		return null;
	}

	@Override
	public Void visit(ArrayType arrayType, Void param) {
		this.codeGenerator.arrayNotationBegin(arrayType);
		arrayType.getType().accept(this, null);
		this.codeGenerator.arrayNotationEnd(arrayType);
		return null;
	}

	public Void visit(StructType structType, Void param) {
		structType.getType().accept(this, null);
		this.codeGenerator.comment("Here");
		return null;
	}
}

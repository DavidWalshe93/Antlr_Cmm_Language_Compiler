package codegeneration.cg;

import ast.ASTNode;
import ast.definitions.*;
import ast.expressions.Variable;
import types.ArrayType;
import types.Type;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: David Walshe
 * Date: 15/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class CodeGenerator implements CG {

	/**
	 * The output file
	 */
	private PrintWriter out;

	public CodeGenerator(String outputFilename, String sourceFilename) {
		try {
			this.out = new PrintWriter(outputFilename);
		} catch (IOException e) {
			System.err.println("Error opening the file " + outputFilename + ".");
			System.exit(-1);
		}
		this.source(sourceFilename);
	}

	@Override
	public void source(String infilename) {
		out.println("\n#source\t\"" + infilename + "\"\n");
		out.flush();
	}

	@Override
	public void line(ASTNode node) {
		out.println("\n#line\t" + node.getLine());
		out.flush();
	}

	@Override
	public void newline() {
		out.println();
		out.flush();
	}


	@Override
	public void commentln(String message) {
		out.println("\t' * " + message + "");
		out.flush();
	}

	@Override
	public void comment(String message) {
		out.print("\t' * " + message + "");
		out.flush();
	}

	@Override
	public void mainCall() {
		out.println("\n' Invocation to the main function");
		out.println("call main");
		out.println("halt\n");
		out.flush();
	}

	@Override
	public void push(char constant) {
		out.println("\tpushb\t" + (int) constant + "");
		out.flush();
	}

	@Override
	public void push(int constant) {
		out.println("\tpushi\t" + constant + "");
		out.flush();
	}

	@Override
	public void push(double constant) {
		out.println("\tpushf\t" + constant + "");
		out.flush();
	}

	@Override
	public void pusha(int offset) {
		out.println("\tpusha\t" + offset + "");
		out.flush();
	}

	@Override
	public void load(Type type) {
		out.println("\tload" + type.suffix());
		out.flush();
	}

	@Override
	public void store(Type type) {
		out.println("\tstore" + type.suffix());
		out.flush();
	}

	@Override
	public void output(Type type) {
		out.println("\tout" + type.suffix());
		out.flush();
	}

	@Override
	public void in(Type type) {
		out.println("\tin" + type.suffix());
		out.flush();
	}

	@Override
	public void varDef(VariableDefinition variableDefinition) {
		out.println(" " + variableDefinition.getName() + " (offset " + variableDefinition.getOffset() + ")");
		out.flush();
	}

	public void recordDef(RecordDefinition recordDefinition) {
		this.commentln("  |-- " + recordDefinition.getType() + " " + recordDefinition.getName() + " (offset " + recordDefinition.getOffset() + ")");
	}

	@Override
	public void funcDef(FunctionDefinition functionDefinition) {
		out.println(" " + functionDefinition.getName() + ":");
		out.flush();
	}

	@Override
	public void enter(int localByteSize) {
		out.println("\tenter " + Math.abs(localByteSize));
	}

	@Override
	public void ret(int localsByteSize, int parametersByteSize, int returnByteSize) {
		out.println("\tret " + returnByteSize +
				", " + localsByteSize +
				", " + parametersByteSize);
		out.flush();

	}

	@Override
	public void structDef(StructDefinition structDefinition) {
		this.commentln("struct " + structDefinition.getName());
	}

	@Override
	public void pushAddress(Variable variable) {
		Definition definition = variable.getDefinition();
		this.pusha(definition.getOffset());
	}

	public void add(Type type) {
		out.println("\tadd" + type.suffix());
		out.flush();
	}

	public void sub(Type type) {
		out.println("\tsub" + type.suffix());
		out.flush();
	}

	public void mul(Type type) {
		out.println("\tmul" + type.suffix());
		out.flush();
	}

	public void div(Type type) {
		out.println("\tdiv" + type.suffix());
		out.flush();
	}

	public void mod(Type type) {
		out.println("\tmod" + type.suffix());
		out.flush();
	}

	public void arithmetic(String operator, Type type) {
		switch (operator.charAt(0)) {
			case '+':
				this.add(type);
				break;
			case '-':
				this.sub(type);
				break;
			case '/':
				this.div(type);
				break;
			case '*':
				this.mul(type);
				break;
			case '%':
				this.mod(type);
				break;
			default:
				assert false : "Unknown arithmetic operator: " + operator;
		}
	}

	@Override
	public void gt(Type type) {
		out.println("\tgt" + type.suffix());
		out.flush();
	}

	@Override
	public void lt(Type type) {
		out.println("\tlt" + type.suffix());
		out.flush();
	}

	@Override
	public void ge(Type type) {
		out.println("\tge" + type.suffix());
		out.flush();
	}

	@Override
	public void le(Type type) {
		out.println("\tle" + type.suffix());
		out.flush();
	}

	@Override
	public void eq(Type type) {
		out.println("\teq" + type.suffix());
		out.flush();
	}

	@Override
	public void ne(Type type) {
		out.println("\tne" + type.suffix());
		out.flush();
	}

	@Override
	public void comparison(String operator, Type type) {
		switch (operator) {
			case ">=":
				this.ge(type);
				break;
			case "<=":
				this.le(type);
				break;
			case "==":
				this.eq(type);
				break;
			case "!=":
				this.ne(type);
				break;
			case ">":
				this.gt(type);
				break;
			case "<":
				this.lt(type);
				break;
			default:
				assert false : "Unknown comparison operator: " + operator;
		}
	}

	@Override
	public void and(Type type) {
		out.println("\tand");
		out.flush();
	}

	@Override
	public void or(Type type) {
		out.println("\tor");
		out.flush();
	}

	@Override
	public void not(Type type) {
		out.println("\tnot");
		out.flush();
	}

	@Override
	public void logic(String operator, Type type) {
		switch (operator) {
			case "&&":
				this.and(type);
				break;
			case "||":
				this.or(type);
				break;
			case "!":
				this.not(type);
				break;
			default:
				assert false : "Unknown logic operator: " + operator;
		}
	}

	@Override
	public void cast(String castCommand) {
		if (!castCommand.equals("")) {
			out.println("\t" + castCommand);
			out.flush();
		}
	}

	@Override
	public void arrayNotationBegin(ArrayType arrayType) {
		out.print("[" + arrayType.getArraySize() + ",");
		out.flush();
	}

	@Override
	public void arrayNotationEnd(ArrayType arrayType) {
		out.print("]");
		out.flush();
	}

	public void type(Type type) {
		out.print(type + "");
		out.flush();
	}


}

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

public class CodeGenerator {

	/**
	 * The output file
	 */
	private PrintWriter out;
	private int labels = 0;

	public CodeGenerator(String outputFilename, String sourceFilename) {
		try {
			this.out = new PrintWriter(outputFilename);
		} catch (IOException e) {
			System.err.println("Error opening the file " + outputFilename + ".");
			System.exit(-1);
		}
		String osSeparator = System.getProperty("file.separator");
		String source = sourceFilename;
		try {
			if (sourceFilename.contains(osSeparator))
				source = sourceFilename.substring(sourceFilename.lastIndexOf(osSeparator) + 1);
			else if (sourceFilename.contains("/"))
				source = sourceFilename.substring(sourceFilename.lastIndexOf("/") + 1);
		} catch (Exception e) {
			source = sourceFilename;
			System.out.println(e.toString());
		}
		this.source(source);
	}

	public void close() {
		out.close();
	}

	
	public void source(String infilename) {
		out.println("\n#source\t\"" + infilename + "\"\n");
		out.flush();
	}


	public void line(ASTNode node) {
		out.println("\n#line\t" + node.getLine());
		out.flush();
	}


	public void newline() {
		out.println();
		out.flush();
	}


	public void offset(Definition definition) {
		out.println(" (offset " + definition.getOffset() + ")");
		out.flush();
	}


	
	public void commentln(String message) {
		out.println("\t' * " + message + "");
		out.flush();
	}


	public void comment(String message) {
		out.print("\t' * " + message + "");
		out.flush();
	}


	public void mainCall() {
		out.println("\n' Invocation to the main function");
		out.println("call main");
		out.println("halt\n");
		out.flush();
	}


	public void push(char constant) {
		out.println("\tpushb\t" + (int) constant + "");
		out.flush();
	}


	public void push(int constant) {
		out.println("\tpushi\t" + constant + "");
		out.flush();
	}


	public void push(double constant) {
		out.println("\tpushf\t" + constant + "");
		out.flush();
	}

	public void pusha(int offset) {
		out.println("\tpusha\t" + offset + "");
		out.flush();
	}


	public void load(Type type) {
		out.println("\tload" + type.suffix());
		out.flush();
	}


	public void store(Type type) {
		out.println("\tstore" + type.suffix());
		out.flush();
	}

	public void pop(Type type) {
		out.println("\tpop" + type.suffix());
	}

	
	public void output(Type type) {
		out.println("\tout" + type.suffix());
		out.flush();
	}


	public void in(Type type) {
		out.println("\tin" + type.suffix());
		out.flush();
	}


	public void varDef(VariableDefinition variableDefinition) {
		out.print(" " + variableDefinition.getName());
		this.offset(variableDefinition);
		out.flush();
	}

	public void recordDef(RecordDefinition recordDefinition) {
		out.print(recordDefinition.getName());
		out.flush();
	}

	
	public void funcDef(FunctionDefinition functionDefinition) {
		out.println(" " + functionDefinition.getName() + ":");
		out.flush();
	}


	public void enter(int localByteSize) {
		out.println("\tenter\t" + Math.abs(localByteSize));
	}

	public void call(String funcName) {
		out.println("\tcall\t" + funcName);
		out.flush();
	}


	public void ret(int returnByteSize, int localsByteSize, int parametersByteSize) {
		out.println("\tret\t" + returnByteSize +
				", " + Math.abs(localsByteSize) +
				", " + parametersByteSize);
		out.flush();

	}


	public void structDef(StructDefinition structDefinition) {
		out.print(" " + structDefinition.getName());
		this.offset(structDefinition);
		out.flush();
	}

	public void typeDef(TypeDefinition typeDefinition) {
		out.print(" " + typeDefinition.getName());
		this.offset(typeDefinition);
		out.flush();
	}


	public void print(String string) {
		out.print(string);
		out.flush();
	}

	
	public void pushAddress(Variable variable) {
		this.pusha(variable.getDefinition().getOffset());
	}


	public void pushBp() {
		out.println("\tpush\tbp");
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


	public void gt(Type type) {
		out.println("\tgt" + type.suffix());
		out.flush();
	}


	public void lt(Type type) {
		out.println("\tlt" + type.suffix());
		out.flush();
	}


	public void ge(Type type) {
		out.println("\tge" + type.suffix());
		out.flush();
	}


	public void le(Type type) {
		out.println("\tle" + type.suffix());
		out.flush();
	}


	public void eq(Type type) {
		out.println("\teq" + type.suffix());
		out.flush();
	}


	public void ne(Type type) {
		out.println("\tne" + type.suffix());
		out.flush();
	}


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


	public void and(Type type) {
		out.println("\tand");
		out.flush();
	}


	public void or(Type type) {
		out.println("\tor");
		out.flush();
	}


	public void not(Type type) {
		out.println("\tnot");
		out.flush();
	}


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


	public void cast(String castCommand) {
		if (!castCommand.equals("")) {
			out.println("\t" + castCommand);
			out.flush();
		}
	}


	public void arrayNotationBegin(ArrayType arrayType) {
		out.print("[" + arrayType.getArraySize() + ",");
		out.flush();
	}


	public void arrayNotationEnd(ArrayType arrayType) {
		out.print("]");
		out.flush();
	}

	public void type(Type type) {
		out.print(type + "");
		out.flush();
	}

	public int getLabels(int howMany) {
		int temp = this.labels;
		this.labels += howMany;

		return temp;
	}

	public void label(int label) {
		out.println(" label" + label + ":");
		out.flush();
	}

	public void jz(int label) {
		out.println("\tjz\tlabel" + label);
		out.flush();
	}

	public void jnz(int label) {
		out.println("\tjz\tlabel" + label);
		out.flush();
	}

	public void jmp(int label) {
		out.println("\tjmp\tlabel" + label);
		out.flush();
	}

}

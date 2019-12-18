package codegeneration.cg;

import ast.ASTNode;
import ast.definitions.FunctionDefinition;
import ast.definitions.StructDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Variable;
import types.ArrayType;
import types.Type;

/**
 * Author: David Walshe
 * Date: 15/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public interface CG {

	void line(ASTNode node);

	void source(String infileName);

	void newline();

	void commentln(String message);

	void comment(String message);

	void mainCall();

	void push(char constant);

	void push(int constant);

	void push(double constant);

	void pusha(int offset);

	void load(Type type);

	void store(Type type);

	void output(Type type);

	void in(Type type);

	void varDef(VariableDefinition variableDefinition);

	void funcDef(FunctionDefinition functionDefinition);

	void enter(int localByteSize);

	void structDef(StructDefinition structDefinition);

	void pushAddress(Variable variable);

	void arithmetic(String operator, Type type);

	void add(Type type);

	void sub(Type type);

	void mul(Type type);

	void div(Type type);

	void mod(Type type);

	void comparison(String operator, Type type);

	void gt(Type type);

	void lt(Type type);

	void ge(Type type);

	void le(Type type);

	void eq(Type type);

	void ne(Type type);

	void logic(String operator, Type type);

	void and(Type type);

	void or(Type type);

	void not(Type type);

	void cast(String castCommand);

	void ret(int localByteSize, int parameterByteSize, int returnByteSize);

	void arrayNotationBegin(ArrayType arrayType);

	void arrayNotationEnd(ArrayType arrayType);

	void type(Type type);

}

package codegeneration.cg;

import ast.expressions.Dot;
import ast.expressions.Indexing;
import ast.expressions.Variable;

/**
 * Author: David Walshe
 * Date: 15/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

	ValueCGVisitor valueCGVisitor;

	public AddressCGVisitor(CodeGenerator codeGenerator, ValueCGVisitor valueCGVisitor) {
		super(codeGenerator);
		this.valueCGVisitor = valueCGVisitor;
	}
	// CHECK - verify implementation is correct.

	@Override
	public Void visit(Indexing indexing, Void param) {
		indexing.getExpression().accept(this, null);
		indexing.getArrayIndex().accept(this.valueCGVisitor, null);
		codeGenerator.push(indexing.getType().numberOfBytes());
		codeGenerator.mul(indexing.getArrayIndex().getType());
		codeGenerator.add(indexing.getArrayIndex().getType());
//        this.codeGenerator.pushAddress(indexing);

		return null;
	}

	@Override
	public Void visit(Dot dot, Void param) {
//        System.out.println(((StructType)dot.getRecord().getType()).getRecordField(dot.getFieldName()).);
		System.out.println("" + dot.getRecord().getClass().getSimpleName()); //.getType()).getRecordField(dot.getFieldName()));
		dot.getRecord().accept(this, null);
//        dot.getRecord().accept(this, null);
//        this.codeGenerator.pushAddress((Variable) dot.getRecord());
//        this.codeGenerator.push(dot.getRecord().getType().getRecordField(dot.getFieldName()).getOffset());
		//this.codeGenerator.push(((StructType)dot.getRecord().getType()).getRecordField(dot.getFieldName()).getOffset());
		//this.codeGenerator.add(dot.getRecord().getType());

		return null;
	}

	@Override
	public Void visit(Variable variable, Void param) {
		this.codeGenerator.pushAddress(variable);

		return null;
	}
}

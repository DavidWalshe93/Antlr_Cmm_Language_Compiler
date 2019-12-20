package codegeneration.cg;

import ast.expressions.Dot;
import ast.expressions.Indexing;
import ast.expressions.Variable;
import types.IntType;
import types.StructType;

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

		return null;
	}

	@Override
	public Void visit(Dot dot, Void param) {
		dot.getRecord().accept(this, null);
		this.codeGenerator.push(((StructType) dot.getRecord().getType()).getRecordField(dot.getFieldName()).getOffset());
		this.codeGenerator.add(IntType.getInstance());
		return null;
	}

	@Override
	public Void visit(Variable variable, Void param) {
		if (variable.getDefinition().getScope() == 0) {
			this.codeGenerator.pushAddress(variable);
		} else {
			this.codeGenerator.pushBp();
			this.codeGenerator.push(variable.getDefinition().getOffset());
			this.codeGenerator.add(IntType.getInstance());
		}

		return null;
	}
}

package codegeneration.cg;

import ast.expressions.*;

/**
 * Author: David Walshe
 * Date: 15/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {       // CHECK - is parameter type required for read/write? is boolean type choice correct?
	//todo change bool to Void

	private AddressCGVisitor addressCGVisitor;

	public ValueCGVisitor(CodeGenerator codeGenerator) {
		super(codeGenerator);
		this.addressCGVisitor = new AddressCGVisitor(codeGenerator, this);
	}

	@Override
	public Void visit(Arithmetic arithmetic, Void param) {
		arithmetic.getOperand1().accept(this, param);
		this.codeGenerator.cast(arithmetic.getOperand1().getType().convertTo(arithmetic.getType()));
		arithmetic.getOperand2().accept(this, param);
		this.codeGenerator.cast(arithmetic.getOperand2().getType().convertTo(arithmetic.getType()));
		codeGenerator.arithmetic(arithmetic.getOperator(), arithmetic.getType());

		return null;
	}

	@Override
	public Void visit(Cast cast, Void param) {
		cast.getExpression().accept(this, param);
		codeGenerator.cast(cast.getExpression().getType().convertTo(cast.getCastType()));

		return null;
	}

	@Override
	public Void visit(CharLiteral charLiteral, Void param) {
		codeGenerator.push(charLiteral.getValue());
		return null;
	}

	@Override
	public Void visit(Comparison comparison, Void param) {
		comparison.getOperand1().accept(this, param);
		comparison.getOperand2().accept(this, param);

		codeGenerator.comparison(comparison.getOperator(), comparison.getType());

		return null;
	}

	@Override
	public Void visit(FunctionExpression functionExpression, Void param) {
		return super.visit(functionExpression, param);
	}

	@Override
	public Void visit(Indexing indexing, Void param) {
		indexing.accept(this.addressCGVisitor, null);
		codeGenerator.load(indexing.getType());
		return null;
	}

	@Override
	public Void visit(IntLiteral intLiteral, Void param) {
		codeGenerator.push(intLiteral.getValue());
		return null;
	}

	@Override
	public Void visit(Logic logic, Void param) {
		logic.getOperand1().accept(this, param);
		logic.getOperand2().accept(this, param);

		this.codeGenerator.logic(logic.getOperator(), logic.getType());

		return null;
	}

	@Override
	public Void visit(Not not, Void param) {
		not.getOperand().accept(this, param);

		this.codeGenerator.logic("!", not.getOperand().getType());

		return null;
	}

	@Override
	public Void visit(RealLiteral realLiteral, Void param) {
		codeGenerator.push(realLiteral.getValue());

		return null;
	}

	@Override
	public Void visit(Dot dot, Void param) {
		dot.accept(this.addressCGVisitor, null);
		codeGenerator.load(dot.getType());
		return null;
	}

	@Override
	public Void visit(UnaryMinus unaryMinus, Void param) {
		return super.visit(unaryMinus, param);
	}

	@Override
	public Void visit(Variable variable, Void param) {    // CHECK - is using a parameter correct?
		variable.accept(this.addressCGVisitor, null);
		codeGenerator.load(variable.getType());
		return null;
	}
}

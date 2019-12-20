package ast.statements;

import ast.expressions.Expression;
import visitor.Visitor;

import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 20/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class If extends Conditional implements Statement {

	private Else _else;

    public If(int line, int column, Expression condition, ArrayList<Statement> statements) {
        super(line, column, condition, statements);
    }

	public Else getElse() {
		return _else;
	}

	public void setElse(Else _else) {
		this._else = _else;
	}

    @Override
    public String toString() {
        return "if(" + this.getCondition().toString() + ") {" + this.getStatementsAsString() + "}";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}

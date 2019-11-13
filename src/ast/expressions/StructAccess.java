package ast.expressions;

import visitor.Visitor;

/**
 * Author: David Walshe
 * Date: 21/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class StructAccess extends AbstractExpression {

    private Expression record;
    private String fieldName;

    public StructAccess(int line, int column, Expression record, String fieldName) {
        super(line, column);
        this.record = record;
        this.fieldName = fieldName;
    }

    public Expression getRecord() {
        return record;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return this.getRecord().toString() + "." + this.getFieldName();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}

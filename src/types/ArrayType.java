package types;

import ast.ASTNode;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: David Walshe
 * Date: 08/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class ArrayType extends AbstractType {

    private Type type;
    private int arraySize;

    public ArrayType(Type type, int arraySize) {
        super(0, 0);
        this.type = type;
        this.arraySize = arraySize;
    }

    public static ArrayType createArray(Type type, ArrayList<Integer> arraySizes) {
        ArrayType arrayType = new ArrayType(type, arraySizes.get(arraySizes.size() - 1));
        for (int i = arraySizes.size() - 2; i >= 0; i--) {
            arrayType = new ArrayType(arrayType, arraySizes.get(i));
        }
        return arrayType;
    }

    public Type getType() {
        return type;
    }

    public int getArraySize() {
        return arraySize;
    }

    @Override
    public String toString() {
        if (this.getType() instanceof ArrayType) {
            String arrayString = this.getType() + "";
            String[] splitArrayString = arrayString.split("\\[", -1);

            return splitArrayString[0] + "[" + this.getArraySize() + "]" + "[" + String.join("[", Arrays.copyOfRange(splitArrayString, 1, splitArrayString.length));
        } else
            return this.getType() + "[" + this.getArraySize() + "]";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type squareBrackets(Type type, ASTNode node) {
        if (type instanceof IntType)
            return this.type;
        return new ErrorType("Array index must be int", node);
    }

    @Override
    public Type assignment(Type type, ASTNode node) {
        if (type instanceof ArrayType) {
            return new ErrorType("Arrays cannot be assigned", node);
        }
        return this.getType().assignment(type, node);
    }
}

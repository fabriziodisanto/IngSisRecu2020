package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Pow extends BinaryOperation {

    public Pow(Function leftOperand, Function rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Double evaluate() throws VariableNotDefinedException {
        return Math.pow(getLeftOperand().evaluate(), getRightOperand().evaluate());
    }

    @Override
    public String print() {
        return getLeftOperand().print() + " ^ " + getRightOperand().print();
    }

    @Override
    public <T> T acceptVisitor(Visitor<T> visitor) throws VariableNotDefinedException {
        return visitor.visitPow(this);
    }
}

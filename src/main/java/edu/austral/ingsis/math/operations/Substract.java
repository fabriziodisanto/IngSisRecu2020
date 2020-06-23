package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Substract extends BinaryOperation {

    public Substract(Function leftOperand, Function rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Double evaluate() throws VariableNotDefinedException {
        return getLeftOperand().evaluate() - getRightOperand().evaluate();
    }

    @Override
    public String print() {
        return getLeftOperand().print() + " - " + getRightOperand().print();
    }

    @Override
    public <T> T acceptVisitor(Visitor<T> visitor) throws VariableNotDefinedException {
        return visitor.visitSubstract(this);
    }
}

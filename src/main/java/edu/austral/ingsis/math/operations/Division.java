package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Division extends BinaryOperation {

    public Division(Function leftOperand, Function rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Double evaluate() throws VariableNotDefinedException {
        return getLeftOperand().evaluate() / getRightOperand().evaluate();
    }

    @Override
    public String print() {
        return getLeftOperand().print() + " / " + getRightOperand().print();
    }

    @Override
    public <T> T acceptVisitor(Visitor<T> visitor) throws VariableNotDefinedException {
        return visitor.visitDivision(this);
    }
}

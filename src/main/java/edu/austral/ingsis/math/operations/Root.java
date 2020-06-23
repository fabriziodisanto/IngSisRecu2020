package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Root extends BinaryOperation {

    public Root(Function leftOperand, Function rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Double evaluate() throws VariableNotDefinedException {
        if (getRightOperand().evaluate().equals(2d)) return Math.sqrt(getLeftOperand().evaluate());
        return Math.pow(getLeftOperand().evaluate(), 1d/getRightOperand().evaluate());
    }

    @Override
    public String print() {
        return getLeftOperand().print() + " ^ (1/ " + getRightOperand().print() + " )";
    }

    @Override
    public <T> T acceptVisitor(Visitor<T> visitor) throws VariableNotDefinedException {
        return visitor.visitRoot(this);
    }
}

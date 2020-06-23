package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Paren extends UnaryOperation{

    public Paren(Function middleOperation) {
        super(middleOperation);
    }

    @Override
    public Double evaluate() throws VariableNotDefinedException {
        return getMiddleOperation().evaluate();
    }

    @Override
    public String print() {
        return "(" + getMiddleOperation().print() + ")";
    }

    @Override
    public <T> T acceptVisitor(Visitor<T> visitor) throws VariableNotDefinedException {
        return visitor.visitParen(this);
    }
}

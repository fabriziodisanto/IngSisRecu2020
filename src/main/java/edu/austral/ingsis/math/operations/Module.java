package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Module extends UnaryOperation {

    public Module(Function middleOperation) {
        super(middleOperation);
    }

    @Override
    public Double evaluate() throws VariableNotDefinedException {
        return Math.abs(getMiddleOperation().evaluate());
    }

    @Override
    public String print() {
        return "|" + getMiddleOperation().print() + "|";
    }

    @Override
    public <T> T acceptVisitor(Visitor<T> visitor) throws VariableNotDefinedException {
        return visitor.visitModule(this);
    }

}

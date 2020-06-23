package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Number;

public class EvaluateVisitor implements Visitor<Double> {

    @Override
    public Double visitSum(Sum sum) throws VariableNotDefinedException {
        return sum.evaluate();
    }

    @Override
    public Double visitSubstract(Substract substract) throws VariableNotDefinedException {
        return substract.evaluate();
    }

    @Override
    public Double visitMultiply(Multiply multiply) throws VariableNotDefinedException {
        return multiply.evaluate();
    }

    @Override
    public Double visitDivision(Division division) throws VariableNotDefinedException {
        return division.evaluate();
    }

    @Override
    public Double visitPow(Pow pow) throws VariableNotDefinedException {
        return pow.evaluate();
    }

    @Override
    public Double visitRoot(Root root) throws VariableNotDefinedException {
        return root.evaluate();
    }

    @Override
    public Double visitModule(Module module) throws VariableNotDefinedException {
        return module.evaluate();
    }

    @Override
    public Double visitParen(Paren paren) throws VariableNotDefinedException {
        return paren.evaluate();
    }

    @Override
    public Double visitNumber(Number number) {
        return number.evaluate();
    }

    @Override
    public Double visitVariable(Variable variable) throws VariableNotDefinedException {
        return variable.evaluate();
    }
}

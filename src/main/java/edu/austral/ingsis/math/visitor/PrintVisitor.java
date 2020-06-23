package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Number;

public class PrintVisitor implements Visitor<String> {

    @Override
    public String visitSum(Sum sum) {
        return sum.print();
    }

    @Override
    public String visitSubstract(Substract substract) {
        return substract.print();
    }

    @Override
    public String visitMultiply(Multiply multiply) {
        return multiply.print();
    }

    @Override
    public String visitDivision(Division division) {
        return division.print();
    }

    @Override
    public String visitPow(Pow pow) {
        return pow.print();
    }

    @Override
    public String visitRoot(Root root) {
        return root.print();
    }

    @Override
    public String visitModule(Module module) {
        return module.print();
    }

    @Override
    public String visitParen(Paren paren) {
        return paren.print();
    }

    @Override
    public String visitNumber(Number number) {
        return number.print();
    }

    @Override
    public String visitVariable(Variable variable) {
        return variable.print();
    }
}

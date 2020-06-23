package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BinaryOperation implements Function {

    private Function leftOperand;
    private Function rightOperand;

    public BinaryOperation(Function leftOperand, Function rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public Function getLeftOperand() {
        return leftOperand;
    }

    public Function getRightOperand() {
        return rightOperand;
    }

    @Override
    public List<String> listVariables(){
        return Stream.concat(leftOperand.listVariables().stream(), rightOperand.listVariables().stream())
                .collect(Collectors.toList());
    }
}

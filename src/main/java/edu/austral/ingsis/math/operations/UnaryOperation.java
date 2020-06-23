package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;

import java.util.List;

public abstract class UnaryOperation implements Function {

    private Function middleOperation;

    public UnaryOperation(Function middleOperation) {
        this.middleOperation = middleOperation;
    }

    public Function getMiddleOperation() {
        return middleOperation;
    }

    @Override
    public List<String> listVariables(){
        return middleOperation.listVariables();
    }
}

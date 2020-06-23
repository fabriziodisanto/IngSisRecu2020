package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

import java.util.Collections;
import java.util.List;

public class Variable implements Function {

    private Double value = null;
    private String name;

    public Variable(Double value, String name) {
        this.value = value;
        this.name = name;
    }

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Double evaluate() throws VariableNotDefinedException {
        if (value == null) throw new VariableNotDefinedException();
        return value;
    }

    @Override
    public String print() {
        return name;
    }

    @Override
    public <T> T acceptVisitor(Visitor<T> visitor) throws VariableNotDefinedException {
        return visitor.visitVariable(this);
    }

    @Override
    public List<String> listVariables() {
        return Collections.singletonList(name);
    }
}

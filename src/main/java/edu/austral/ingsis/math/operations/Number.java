package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

import java.util.Collections;
import java.util.List;

public class Number implements Function {

    private Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate() {
        return value;
    }

    @Override
    public String print() {
        String doubleAsString = String.valueOf(value);
        int indexOfDecimal = doubleAsString.indexOf(".");
        if(Double.parseDouble(doubleAsString.substring(indexOfDecimal)) == 0d){
            return doubleAsString.substring(0, indexOfDecimal);
        }
        return value.toString();
    }

    @Override
    public <T> T acceptVisitor(Visitor<T> visitor) {
        return visitor.visitNumber(this);
    }

    @Override
    public List<String> listVariables() {
        return Collections.emptyList();
    }
}

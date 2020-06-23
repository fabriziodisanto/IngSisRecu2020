package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operations.VariableNotDefinedException;
import edu.austral.ingsis.math.visitor.Visitor;

import java.util.List;

public interface Function {
    Double evaluate() throws VariableNotDefinedException;
    String print();
    <T> T acceptVisitor(Visitor<T> visitor) throws VariableNotDefinedException;
    List<String> listVariables();
}

package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Number;

public interface Visitor<T> {

    T visitSum(Sum sum) throws VariableNotDefinedException;
    T visitSubstract(Substract substract) throws VariableNotDefinedException;
    T visitMultiply(Multiply multiply) throws VariableNotDefinedException;
    T visitDivision(Division division) throws VariableNotDefinedException;
    T visitPow(Pow pow) throws VariableNotDefinedException;
    T visitRoot(Root root) throws VariableNotDefinedException;
    T visitModule(Module module) throws VariableNotDefinedException;
    T visitParen(Paren paren) throws VariableNotDefinedException;
    T visitNumber(Number number);
    T visitVariable(Variable variable) throws VariableNotDefinedException;

}

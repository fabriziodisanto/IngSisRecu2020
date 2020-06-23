package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Number;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() throws VariableNotDefinedException {
        final Double result = new Sum(new Number(1d), new Variable(3d, "x")).evaluate();

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() throws VariableNotDefinedException {
        final Double result = new Division(new Number(12d), new Variable(4d, "div")).evaluate();

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() throws VariableNotDefinedException {
        Division div = new Division(new Number(9d), new Variable(3d, "x"));
        Paren paren = new Paren(div);
        final Double result = new Multiply(paren, new Variable(4d, "y")).evaluate();
        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() throws VariableNotDefinedException {
        Division div = new Division(new Number(27d), new Variable(9d, "a"));
        Paren paren = new Paren(div);
        final Double result = new Pow(paren, new Variable(3d, "b")).evaluate();
        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() throws VariableNotDefinedException {
        final Double result = new Root(new Variable(36d, "z"), new Number(2d)).evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() throws VariableNotDefinedException {
        Module module = new Module(new Variable(8d, "value"));
        final Double result = new Substract(module, new Number(8d)).evaluate();
        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() throws VariableNotDefinedException {
        Module module = new Module(new Variable(8d, "value"));
        final Double result = new Substract(module, new Number(8d)).evaluate();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() throws VariableNotDefinedException {
        Paren paren = new Paren(new Substract(new Number(5d), new Variable(2d, "i")));
        final Double result = new Multiply(paren, new Number(8d)).evaluate();

        assertThat(result, equalTo(24d));
    }
}

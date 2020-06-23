package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Number;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() throws VariableNotDefinedException {
        final Double result = new Sum(new Number(1d), new Number(6d)).evaluate();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() throws VariableNotDefinedException {
        final Double result = new Division(new Number(12d), new Number(2d)).evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() throws VariableNotDefinedException {
        Division div = new Division(new Number(9d), new Number(2d));
        Paren paren = new Paren(div);
        final Double result = new Multiply(paren, new Number(3d)).evaluate();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() throws VariableNotDefinedException {
        Division div = new Division(new Number(27d), new Number(6d));
        Paren paren = new Paren(div);
        final Double result = new Pow(paren, new Number(2d)).evaluate();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() throws VariableNotDefinedException {
        final Double result = new Root(new Number(36d), new Number(2d)).evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() throws VariableNotDefinedException {
        final Double result = new Module(new Number(136d)).evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() throws VariableNotDefinedException {
        final Double result = new Module(new Number(-136d)).evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() throws VariableNotDefinedException {
        Substract substract = new Substract(new Number(5d), new Number(5d));
        Paren paren = new Paren(substract);
        final Double result = new Multiply(paren, new Number(8d)).evaluate();

        assertThat(result, equalTo(0d));
    }
}

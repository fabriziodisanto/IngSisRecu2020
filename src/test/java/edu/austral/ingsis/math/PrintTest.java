package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Number;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final String result = new Sum(new Number(1d), new Number(6d)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        final String result = new Division(new Number(12d), new Number(2d)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        Division div = new Division(new Number(9d), new Number(2d));
        Paren paren = new Paren(div);
        final String result = new Multiply(paren, new Number(3d)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        Division div = new Division(new Number(27d), new Number(6d));
        Paren paren = new Paren(div);
        final String result = new Pow(paren, new Number(2d)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        Module module = new Module(new Variable("value"));
        final String result = new Substract(module, new Number(8d)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        Module module = new Module(new Variable("value"));
        final String result = new Substract(module, new Number(8d)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        Paren paren = new Paren(new Substract(new Number(5d), new Variable("i")));
        final String result = new Multiply(paren, new Number(8d)).print();

        assertThat(result, equalTo(expected));
    }
}

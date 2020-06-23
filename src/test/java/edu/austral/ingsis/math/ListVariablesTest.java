package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Number;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = new Sum(new Number(1d), new Number(6d)).listVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = new Division(new Number(12d), new Variable("div")).listVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Division div = new Division(new Number(9d), new Variable("x"));
        Paren paren = new Paren(div);
        final List<String> result = new Multiply(paren, new Variable("y")).listVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Division div = new Division(new Number(27d), new Variable("a"));
        Paren paren = new Paren(div);
        final List<String> result = new Pow(paren, new Variable("b")).listVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final List<String> result = new Root(new Variable("z"), new Number(2d)).listVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Module module = new Module(new Variable("value"));
        final List<String> result = new Substract(module, new Number(8d)).listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Module module = new Module(new Variable("value"));
        final List<String> result = new Substract(module, new Number(8d)).listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Paren paren = new Paren(new Substract(new Number(5d), new Variable("i")));
        final List<String> result = new Multiply(paren, new Number(8d)).listVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}

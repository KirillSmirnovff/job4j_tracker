package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionDiapason.diapason(1, 4, x -> 2 * Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(3D, 9D, 19D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionDiapason.diapason(1, 4, x -> Math.pow(2, x) + 2);
        List<Double> expected = Arrays.asList(4D, 6D, 10D);
        assertThat(result, is(expected));
    }

}
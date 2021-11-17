package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void transform() {
        Matrix  toList = new Matrix();
        Integer[][] matrix = new Integer[][] {{1, 2, 3, 4}, {9, 8, 7, 6}};
        List<Integer> expected  = List.of(1, 2, 3, 4, 9, 8, 7, 6);
        List<Integer> result = toList.transform(matrix);
        assertThat(result, is(expected));
    }
}
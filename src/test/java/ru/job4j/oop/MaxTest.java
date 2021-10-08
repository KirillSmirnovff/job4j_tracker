package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;

public class MaxTest {

    @Test
    public void whenMaxOf2Then2() {
        int first = 1;
        int second = 2;
        int result = Max.max(first, second);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMaxOf3Then7() {
        int first = 4;
        int second = 7;
        int third = 1;
        int result = Max.max(first, second, third);
        int expected = 7;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMaxOf4Then9() {
        int first = 9;
        int second = 3;
        int third = 6;
        int fourth = 3;
        int result = Max.max(first, second, third, fourth);
        int expected = 9;
        Assert.assertEquals(result, expected);
    }
}
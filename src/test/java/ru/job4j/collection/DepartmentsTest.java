package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenEquals() {
        int rsl = new DepDescComp().compare(
                "K1/SK1/SSK2",
                "K1/SK1/SSK2"
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenSortAsc() {
        List<String> input = Arrays.asList(
                "K2/SK2",
                "K1",
                "K1/SSK2",
                "K2"
        );
        List<String> expected = List.of(
                "K1",
                "K1/SSK2",
                "K2",
                "K2/SK2"
        );
        Departments.sortAsc(input);
        assertThat(input, is(expected));
    }

    @Test
    public void whenSortDesc() {
        List<String> input = Arrays.asList(
                "K2/SK2",
                "K1",
                "K1/SSK2",
                "K2"
        );
        List<String> expected = List.of(
                "K2",
                "K2/SK2",
                "K1",
                "K1/SSK2"
        );
        Departments.sortDesc(input);
        assertThat(input, is(expected));
    }
}
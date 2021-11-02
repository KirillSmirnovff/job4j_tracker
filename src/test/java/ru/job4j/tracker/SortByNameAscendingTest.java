package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortByNameAscendingTest {

    @Test
    public void compareAscending() {
        List<Item> items = Arrays.asList(new Item("Testing framework"),
                new Item("Fix keyboard"),
                new Item("virtual environment fix")
        );
        List<Item> expected = Arrays.asList(new Item("Fix keyboard"),
                new Item("Testing framework"),
                new Item("virtual environment fix")
        );
        items.sort(new SortByNameAscending());
        assertThat(expected, is(items));
    }

    @Test
    public void compareDescending() {
        List<Item> items = Arrays.asList(new Item("Testing framework"),
                new Item("Fix keyboard"),
                new Item("virtual environment fix")
        );
        List<Item> expected = Arrays.asList(new Item("virtual environment fix"),
                new Item("Testing framework"),
                new Item("Fix keyboard")
        );
        items.sort(new SortByNameDescending());
        assertThat(expected, is(items));
    }
}
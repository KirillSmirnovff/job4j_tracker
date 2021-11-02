package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenByNameAsc() {
        Comparator<Job> comparator = new JobByNameAsc();
        int result = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenByNameDesc() {
        Comparator<Job> comparator = new JobByNameDesc();
        int result = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenByPriorityAsc() {
        Comparator<Job> comparator = new JobByPriorityAsc();
        int result = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenByPriorityDesc() {
        Comparator<Job> comparator = new JobByPriorityDesc();
        int result = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobByNameDesc()
                .thenComparing(new JobByPriorityDesc());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpPriorityName = new JobByPriorityAsc()
                .thenComparing(new JobByNameAsc());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}
package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() >= 70;
        List<Student> rsl = sc.collectByScore(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(90, "Surname9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() >= 50
                && student.getScore() < 70;
        List<Student> rsl = sc.collectByScore(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassV() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() < 50;
        List<Student> rsl = sc.collectByScore(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenWrongScoreThenException() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(110, "Surname6"),
                new Student(90, "Surname9")
        );
    }

    @Test
    public void whenCollectAllThenToMap() {
        Student one = new Student(10, "Surname1");
        Student two = new Student(30, "Surname3");
        Student three = new Student(40, "Surname4");
        Student four = new Student(40, "Surname4");
        Student five = new Student(60, "Surname6");
        Student six = new Student(70, "Surname6");
        Student seven = new Student(90, "Surname9");
        List<Student> students = List.of(
                one, two, three, four,
                five, six, seven
        );
        School sc = new School();
        Map<String, Student> rsl = sc.collectAll(students);
        Map<String, Student> expected = Map.of(
                "Surname1", one,
                "Surname3", two,
                "Surname4", three,
                "Surname6", six,
                "Surname9", seven
        );
        assertThat(rsl, is(expected));
    }
}
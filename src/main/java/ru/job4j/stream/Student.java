package ru.job4j.stream;

import java.util.Objects;

public class Student {
    private int score;

    private String surname;

    public Student(int score, String surname) throws IllegalArgumentException {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score field must be from 1 to 100");
        }
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }
}
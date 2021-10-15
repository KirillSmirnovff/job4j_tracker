package ru.job4j.oop.poly;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student student = freshman;
        Object stud = student;
    }
}

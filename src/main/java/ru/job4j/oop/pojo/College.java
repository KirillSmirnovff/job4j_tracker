package ru.job4j.oop.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Kolesnikov Dmitry Aleksandrovich");
        student.setGroup(1);
        student.setEntered(new Date());
        System.out.println("Студент " + student.getName() + " поступил в " + student.getGroup()
                + " группу " + student.getEntered());
    }
}

package ru.job4j.oop.poly.casting;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус едет по шоссе.");
    }
}

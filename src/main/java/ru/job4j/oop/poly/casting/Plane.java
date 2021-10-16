package ru.job4j.oop.poly.casting;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летит в воздухе.");
    }
}

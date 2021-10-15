package ru.job4j.oop.poly;

public class Bus implements Transport {

    @Override
    public void ride() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int count) {
        System.out.println("В автобусе " + count + " пассажиров");
    }

    @Override
    public double refuel(double fuel) {
        double price = 2;
        return price * fuel;
    }
}

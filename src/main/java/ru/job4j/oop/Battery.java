package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int value) {
        this.load = value;
    }

    public void charge(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery firstBattery = new Battery(4000);
        Battery secondBattery = new Battery(1000);
        System.out.println("Кол-во заряда первого аккумулятора: " + firstBattery.load + " mAh\n"
                + "Кол-во заряда второго аккумулятора: " + secondBattery.load + " mAh");
        firstBattery.charge(secondBattery);
        System.out.println("Кол-во заряда первого аккумулятора: " + firstBattery.load + " mAh\n"
                + "Кол-во заряда второго аккумулятора: " + secondBattery.load + " mAh");
    }
}

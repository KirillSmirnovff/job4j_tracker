package ru.job4j.oop;

public class Dentist extends Doctor {
    private int teethCount;

    public Dentist(String name, String surname, String education,
                   String birthday, boolean doctorate, int teethCount) {
        super(name, surname, education, birthday, doctorate);
        this.teethCount = teethCount;
    }

    public int getTeethCount() {
        return teethCount;
    }

    public boolean toothRemoval(Patient patient) {
        return patient.getBadTooth();
    }
}

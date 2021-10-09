package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int amputationCount;

    public Surgeon(String name, String surname, String education,
                   String birthday, boolean doctorate, int amputationCount) {
        super(name, surname, education, birthday, doctorate);
        this.amputationCount = amputationCount;
    }

    public int getAmputationCount() {
        return amputationCount;
    }

    public boolean amputation(Patient patient) {
        return patient.getGangrene();
    }
}

package ru.job4j.oop;

public class Doctor extends Profession {
    private boolean doctorate;

    public Doctor(String name, String surname, String education,
                  String birthday, boolean doctorate) {
        super(name, surname, education, birthday);
        this.doctorate = doctorate;
    }

    public boolean getDoctorate() {
        return doctorate;
    }
}

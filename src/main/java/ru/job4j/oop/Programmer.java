package ru.job4j.oop;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education,
                   String birthday, int category, String language) {
        super(name, surname, education, birthday, category);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public String operatingSystem(SystemConfiguration system) {
        return system.getName();
    }
}

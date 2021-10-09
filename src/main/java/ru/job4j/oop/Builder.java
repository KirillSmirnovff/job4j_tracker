package ru.job4j.oop;

public class Builder extends Engineer {
    private String object;

    public Builder(String name, String surname, String education,
                   String birthday, int category, String object) {
        super(name, surname, education, birthday, category);
        this.object = object;
    }

    public String getObject() {
        return object;
    }

    public String mainMaterial(Materials usage) {
        return "";
    }
}

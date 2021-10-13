package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item first = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String creationTime = first.getTime().format(formatter);
        System.out.println(creationTime);

        Item second = new Item();
        System.out.println(second.toString());
    }
}

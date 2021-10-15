package ru.job4j.oop.poly;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь знать?");
        String question = input.nextLine();
        int random = new Random().nextInt(3);
        String answer = switch (random) {
            case 0 -> "Да";
            case 1 -> "Нет";
            default -> "Может быть";
        };
        System.out.println(answer);
    }
}

package ru.job4j.oop.poly;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 0 && matches <= 3 && matches <= count) {
                turn = !turn;
                count -= matches;
                if (count > 0) {
                    System.out.println("Осталось " + count + " спичек \n");
                }
            } else {
                System.out.println("Вы ввели неверное кол-во спичек, попробуйте еще раз.");
                System.out.println("Осталось " + count + " спичек \n");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
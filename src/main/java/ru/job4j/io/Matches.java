package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name1 = "Игрок 1";
        String name2 = "Игрок 2";
        String n = name1;
        int matches = 11;
        System.out.println("В игре 11 спичек. 2 игрока. Игроки по очереди берут от 1 до 3 спичек. - " +
                "Вводят цифры от 1 до 3. Выигрывает тот, кто забрал последние спички. Игру начинает игрок №1.");

        while (matches > 0) {
            n = name1;
            System.out.println("Ход делает " + n);
            int select1 = Integer.valueOf(input.nextLine());
            matches = matches - select1;
            System.out.println("Осталось " + matches + " спичек.");
            if (matches <= 0) {
                break;
            }
            n = name2;
            System.out.println("Ход делает " + n);
            int select2 = Integer.valueOf(input.nextLine());
            matches = matches - select2;
            System.out.println("Осталось " + matches + " спичек.");
            if (matches <= 0) {
                break;
            }
        }
        System.out.println("Игра окончена. Выиграл " + n);
    }
}

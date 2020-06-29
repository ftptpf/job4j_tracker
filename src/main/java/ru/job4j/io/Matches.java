package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name1 = "Игрок 1";
        String name2 = "Игрок 2";
        String n = name1;
        int matches = 11;
        System.out.println("В игре 11 спичек. 2 игрока. Игроки по очереди берут от 1 до 3 спичек" +
                "(вводят цифры от 1 до 3). Выигрывает тот, кто забрал последние спички. Игру начинает игрок №1.");

        for (int i = 0; matches >= 0; i++) {
            if (i % 2 == 0) {
                n = name1;
            } else {
                n = name2;
            }
            System.out.println("Ход делает " + n);
            int select = Integer.valueOf(input.nextLine());
            if (select > 3 | select <1) {
                System.out.println("Вы ввели некорректное число и пропускаете ход. " +
                        "В следующий раз вводите число 1 или 2 или 3.");
                continue;
            }
            if (matches >= select) {
                matches = matches - select;
            } else {
                System.out.println("Нельзя взять спиичек больше чем их осталось! " +
                        "Будьте внимательны ход переходит другому игроку!");
            }
            System.out.println("Осталось " + matches + " спичек.");
            if (matches <= 0) {
                break;
            }
        }
        System.out.println("Игра окончена. Выиграл " + n);
    }
}

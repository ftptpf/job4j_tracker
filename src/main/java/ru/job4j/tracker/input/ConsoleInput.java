package ru.job4j.tracker.input;

import ru.job4j.tracker.input.Input;

import java.util.Scanner;

/**
 * Получаем даннные от пользователя в консоли.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Возвращаем введенную строку от пользователя.
     * @param question
     * @return
     */
    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Возвращаем введенное число от пользователя.
     * @param question
     * @return
     */
    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }
}

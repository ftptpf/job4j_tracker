package ru.job4j.tracker.input;

/**
 * Интерфейс определяет работу класса по получению данных от пользователя в консоли.
 */
public interface Input {
    /**
     * Ввод строки.
     * @param question
     * @return
     */
    String askStr(String question);

    /**
     * Ввод числа.
     * @param question
     * @return
     */
    int askInt(String question);
}

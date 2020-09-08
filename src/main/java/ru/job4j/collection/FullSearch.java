package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    /**
     * Метод убирает из списка дубликаты задач.
     * @param list список с дубликатами
     * @return список без дубликатов
     */
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task n : list) {
            numbers.add(n.getNumber());
        }

        return numbers;
    }
}

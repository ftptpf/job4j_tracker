package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    /**
     * Метод преобразует список с массивом чисел в список чисел.
     * @param list массив чисел.
     * @return список чисел.
     */
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] m : list) { // берем массив
            for (int n : m) { // берем число в массиве
                rsl.add(n); // добавляем число в список
            }
        }
        return rsl;

    }
}

package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamArray {
    /**
     * Метод фильтрует поток чилес от -10 до 10 оставляя тольок положительные.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = - 10; i <= 10; i++) {
            list.add(i);
        }
        List<Integer> listSort = list.stream().filter(
                ls -> ls >= 0
        ).collect(Collectors.toList());
        listSort.forEach(System.out::println);
    }
}

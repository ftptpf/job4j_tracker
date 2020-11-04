package ru.job4j.stream;

import java.util.List;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    /**
     * Метод фильтрует поток данных по двум параметрам: 1 - фраза которая входит в name, 2 - spent больше определенного значения
     * @param args
     */
    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug")) // фильтр по фразе "Bug" входящей в name
                .filter(task -> task.spent > 30) // фильрт по spent больше 30
                .map(task -> task.name + " " + task.spent) //поток c результатами фильтрации
                .forEach(System.out::println); // вывод на печать каждого элемента потока
    }
}

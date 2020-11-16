package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class StudentLevel {
    /**
     * Метод возвращает список студентов, у которых балл аттестата больше bound.
     * @param students
     * @param bound
     * @return
     */
    public static List<Students> levelOf(List<Students> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull) //используя метод filter убираем null значения
                .sorted((left, right) -> right.getScore() - left.getScore()) // сортируем список по баллам
                .takeWhile(st -> st.getScore() > bound) // используя метод takeWhile получаем значения больше bound
                .collect(Collectors.toList()); // сохраняем поток в List
    }
}

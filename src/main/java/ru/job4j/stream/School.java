package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    /**
     * Метод делит учеников на три группы по общему баллу score:
     * score - может быть в диапазоне от 0 до 100.
     * 10А диапазон балла [70: 100],
     * 10Б диапазон балла [50: 70);
     * 10B диапазон балла (0: 50);
     * @param students
     * @param predicate
     * @return
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }
}

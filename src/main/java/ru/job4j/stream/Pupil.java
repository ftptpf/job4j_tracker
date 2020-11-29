package ru.job4j.stream;

import java.util.List;

public class Pupil {
    /**
     * Класс описывает ученика.
     */
    private String name; // Имя ученика.
    private List<Subject> subjects; //LIST школьных предметов с баллами.

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}

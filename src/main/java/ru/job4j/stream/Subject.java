package ru.job4j.stream;

public class Subject {
    /**
     * Класс описывает школьный предмет и аттестационный балл ученика.
     */
    private String name; // Школьный предмет.
    private int score; // Аттестационный балл ученика.

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

package ru.job4j.oop;

public class Doctor extends Profession {
    private int level;
    private String recommendation;
    private String certification;

    public Doctor() {

    }
    public Doctor(int level, String recommendation, String certification) {
        this.level = level;
        this.recommendation = recommendation;
        this.certification = certification;
    }

    public void listen(String recommendation) {

    }
    public void advice(String recommendation, int level) {

    }
    public void practice(String certification) {

    }
}

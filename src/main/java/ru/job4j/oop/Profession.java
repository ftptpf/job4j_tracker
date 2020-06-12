package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private int birthday;
    private int experience;
    public Profession() {}
    public Profession(String name, String surname) {}
    public Profession(String education) {}
    public Profession(int birthday) {}
    public Profession(String name, String surname, int experience) {}
    public void getName(String name, String surname) {}
    public void educationInfo(String education) {}
    public void getBirthday(int birthday) {}
    public void getExperience(int experience) {}
}

package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    String education;
    private int birthday;
    private int experience;

    public Profession() {

    }
    public Profession(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Profession(String education) {
        this.education = education;
    }
    public Profession(int birthday) {
        this.birthday = birthday;
    }
    public Profession(String name, String surname, int experience) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
    }

    public void getName(String name, String surname) {

    }
    public void educationInfo(String education) {

    }
    public void getBirthday(int birthday) {

    }
    public void getExperience(int experience) {

    }
}

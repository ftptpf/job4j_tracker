package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman fr = new Freshman(); //создаем объект Freshman
        Students st = fr; // делаем приведение с повышением к типу родителя Students
        Object ob = st; // делаем приведение с повышением к типу родителя Object
    }
}

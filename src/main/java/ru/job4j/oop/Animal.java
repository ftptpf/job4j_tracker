package ru.job4j.oop;

public class Animal {
    private String name;
    public Animal() {
        super();
        System.out.println("Load item 1");
    }
    public Animal(String name) {
        super();
        this.name = name;
        System.out.println("Animal " + name);
    }
    public static void main(String[] args) {
        System.out.println("Animal");
    }
}
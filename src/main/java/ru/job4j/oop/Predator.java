package ru.job4j.oop;

public class Predator extends Animal {
    public Predator() {
        super();
        System.out.println("Load item 2");
    }
    public Predator(String name) {
        super(name);
        System.out.println("Predator " + name);
    }
    public static void main(String[] args) {
        System.out.println("Predator");
    }
}
package ru.job4j.oop;

public class Tiger extends Predator {
    public Tiger() {
        super();
        System.out.println("Load item 3");
    }
    public Tiger(String name) {
        super(name);
    }
    public static void main(String[] args) {
        System.out.println("Tiger");
    }
}
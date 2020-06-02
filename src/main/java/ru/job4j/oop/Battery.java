package ru.job4j.oop;

public class Battery {
    private int load;
    public Battery(int power) {
        this.load = power;
    }
    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }
    public static void main(String[] args) {
        Battery first = new Battery(45);
        Battery second = new Battery(35);
        System.out.println("First Battery : " + first.load + " Second Battery : " + second.load);
        first.exchange(second);
        System.out.println("First Battery : " + first.load + " Second Battery : " + second.load);
    }
}

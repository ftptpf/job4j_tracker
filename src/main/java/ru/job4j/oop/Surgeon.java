package ru.job4j.oop;

public class Surgeon extends Doctor {
    private boolean cut;
    private int rehabilitation;

    public Surgeon() {

    }
    public Surgeon(boolean cut, int rehabilitation) {
        this.cut = cut;
        this.rehabilitation = rehabilitation;
    }

    public void operation(boolean cut, int rehabilitation) {

    }
}

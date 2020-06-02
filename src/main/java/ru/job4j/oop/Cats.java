package ru.job4j.oop;

public class Cats {
    private String food;
    private String name;
    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }
    public void eat(String meat) {
        this.food = meat;
    }
    public void giveName(String nick) {
        this.name = nick;
    }
    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cats gav = new Cats();
        gav.eat("kotleta");
        gav.giveName("Gav");
        gav.show();
        System.out.println("There are black's food.");
        Cats black = new Cats();
        black.eat("fish");
        black.giveName("Black");
        black.show();
    }
}

package ru.job4j.oop;

public class BallStory {
    public static void main(String[]  args) {
        Ball colobok = new Ball();
        Fox lis = new Fox();
        Hare zayats = new Hare();
        Wolfs volk = new Wolfs();
        zayats.tryEat(colobok);
        lis.tryEat(colobok);
        volk.tryEat(colobok);
    }
}

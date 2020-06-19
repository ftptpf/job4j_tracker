package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tr = new Tracker();
        Item str = new Item();
        tr.add(str);
        System.out.println(tr.findById(23));
    }
}

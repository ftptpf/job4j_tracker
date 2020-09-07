package ru.job4j.tracker;

public class Item {
    /**
     * Класс Item описывает модель заявки.
     */
    private int id; //уникальный номер заявки
    private String name; // название заявки

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return id + " " + name;
    }

}
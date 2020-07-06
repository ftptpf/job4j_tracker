package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car(); //создаем объект класса Car
        Transport tp = car; // делаем приведение с повышением к типу родителя Transport
        Object obj = car; // делаем приведение с повышением к типу родителя Object
        Object ocar = new Car(); //делаем приведение с понижением при создании объекта типа Object
        Car fromObject = (Car) ocar;

        Object bicycle = new Bicycle();
        Car cb = (Car) bicycle;
    }
}

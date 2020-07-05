package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        boolean go = false;
        int day = 1;
        if (day == 1) {
            go = true;
        } else {
            go = false;
        }
    }

    @Override
    public void passenger(int unit) {
        int people = unit;
        System.out.println(people);
    }

    @Override
    public int refill(int gas) {
        int price = 50;
        int money = gas * price;
        return price;
    }
}

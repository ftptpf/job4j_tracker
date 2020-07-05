package ru.job4j.poly;

public interface Transport {
    void drive();

    void passenger(int unit);

    int refill(int gas);
}

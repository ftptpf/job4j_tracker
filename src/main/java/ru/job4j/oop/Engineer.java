package ru.job4j.oop;

public class Engineer extends Profession{
    private int math;
    private int car;
    private String instrument;
    private String qualification;
    private int period;
    private int deadline;
    public Engineer() {}
    public Engineer(int car, String instrument, String qualification) {}
    public void count(int math, int deadline, int period) {}
    public void draw(String qualification, int instrument) {}
    public void build(int period, int deadline) {}
}

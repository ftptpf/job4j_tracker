package ru.job4j.oop;

public class Engineer extends Profession {
    private int math;
    private int car;
    private String instrument;
    private String qualification;
    int period;
    int deadline;

    public Engineer() {
    }

    public Engineer(int car) {
        this.car = car;
    }

    public Engineer(int car, String instrument, String qualification) {
        this.car = car;
        this.instrument = instrument;
        this.qualification = qualification;
    }

    public Engineer(int period, int deadline) {
        this.period = period;
        this.deadline = deadline;
    }

        public void count(int math, int deadline, int period){}
        public void draw(String qualification, int instrument) {}
        public void build(int period, int deadline) {}
}

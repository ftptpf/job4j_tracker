package ru.job4j.oop;

public class Builder extends Engineer {
    private String plumber;
    private String scheme;

    public Builder(){}
    public Builder(String plumber, int car) {
        super(car);
        this.plumber = plumber;
    }
    public Builder(String scheme, int period, int deadline) {
        super(period, deadline);
        this.scheme = scheme;
    }

    public void plumberWork(String plumber, int car) {}
    public void electricianWork (String scheme) {}
}

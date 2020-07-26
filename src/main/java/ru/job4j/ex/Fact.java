package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {


    }

    public static int calc (int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be more then zero");
        }
        int rls = 1;
        for (int index = 0; index < n; index++) {
            rls *= index;
        }
        return rls;
    }
}

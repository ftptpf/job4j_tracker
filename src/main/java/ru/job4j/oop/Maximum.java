package ru.job4j.oop;

public class Maximum {
    public static int max(int one, int two) {
        return one > two ? one : two;
    }
    public static int max (int one, int two, int three) {
        int t = max(one, two);
        return t > three ? t : three;
    }
    public static int max (int one, int two, int three, int four) {
        int f = max(one, two, three);
        return f > four ? f : four;
    }
}

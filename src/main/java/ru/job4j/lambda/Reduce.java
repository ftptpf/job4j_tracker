package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Reduce {
    public static int summation(int to) {
        int rsl = 0;
        for (int index = 0; index <= to; index++) {
            rsl += index;
        }
        return rsl;
    }

    public static int multiplication(int to) {
        int rsl = 1;
        for (int index = 1; index <= to; index++) {
            rsl *= index;
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println(summation(3));
        System.out.println(summationLm(3));
        System.out.println(multiplication(3));
        System.out.println(multiplicationLm(3));
    }

    private static int loop(int to, BiFunction<Integer, Integer, Integer> func, Supplier<Integer> initValue) {
        int rsl = initValue.get();
        for (int index = 1; index <= to; index++) {
            rsl = func.apply(rsl, index);
        }
        return rsl;
    }

    public static int summationLm(int to) {
        BiFunction<Integer, Integer, Integer> func = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                return left + right;
            }
        };
        Supplier<Integer> initValue = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 0;
            }
        };
        return loop(to, func, initValue);
    }

    public static int multiplicationLm(int to) {
        BiFunction<Integer, Integer, Integer> func = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                return left * right;
            }
        };
        Supplier<Integer> initValue = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1;
            }
        };
        return loop(to, func, initValue);
    }
}

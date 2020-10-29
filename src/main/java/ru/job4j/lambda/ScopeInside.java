package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    /**
     * Метод складывает числа массива.
     * Зона видимости переменных в лямбда выражениях.
     * @param args
     */
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            int xTotal = total;
            total = add(
                    () -> xTotal + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}

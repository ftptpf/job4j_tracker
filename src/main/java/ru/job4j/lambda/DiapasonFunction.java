package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiapasonFunction {
    /**
     * Метод подсчета функции в диапазоне.
     * @param start начальное значение
     * @param end конечное значение
     * @param func функция
     * @return ArrayList
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> f = new ArrayList<>();
        for (int i = start; i < end; i++) {
            f.add(func.apply((double) i));
        }
        return f;
    }
}

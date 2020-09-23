package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        String[] lf = left.split("\\.", 2); //делим строку left по разделителю "." в массив из двух состставляющих
        String[] rf =  right.split("\\.", 2);//делим строку right по разделителю "." в массив из двух состставляющих

        int lint = Integer.parseInt(lf[0]);//строку в массиве по индексу [0] преобразуем в число
        int rint = Integer.parseInt(rf[0]);//строку в массиве по индексу [0] преобразуем в число

        result = Integer.compare(lint, rint);

        return result;
    }
}

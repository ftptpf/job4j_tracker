package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    /**
     * Поэлементное сравнение двух списков, т.е. сравниваем элементы двух списков,
     * находящихся на одних и тех же позициях (под одним и тем же индексом). Сравнение в лексикографическом порядке.
     * При сравнении каждая строка раскладывается на массив символов, которые в свою очередь преобразуются в массив чисел.
     * @param left
     * @param right
     * @return
     */
    @Override
    public int compare(String left, String right) {

        int result = 0;
        int space;
                

        char[] lch = left.toCharArray(); //преобразуем left строку в массив символов
        char[] rch = right.toCharArray(); //преобразуем right строку в массив символов

        if (lch.length > rch.length) {
            space = rch.length;
        } else {
            space = lch.length;
        }


        for (int i = 0; i < space; i++) {
            if (lch[i] != rch[i]) {
                result = Character.compare(lch[i], rch[i]);
                break;
            } else if (lch.length > rch.length ) {
                result = lch[i + 1];
                break;
            } else if (lch.length < rch.length ) {
                result = - rch[i + 1];
                break;
            }
        }

        return result;
    }
}

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

        space = Math.min(lch.length, rch.length); // находим минимальную длину из двух массивов

        for (int i = 0; i < space; i++) {
            result = Character.compare(lch[i], rch[i]); // посимвольно сравниваем в рамках длинны минимального маассива
            if (result != 0) { // если находим не одинаковые символы
                break; // прерываем выполнение цикла
            }
        }
        if (result == 0) {
            result = Integer.compare(lch.length, rch.length); // делаем сравнение длин массивов
        }
        return result;
    }
}

package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        List<String> om1 = new ArrayList<>();
        List<String> om2 = new ArrayList<>();
        for (String el : o1.split("/", 2)) {
            om1.add(el);
        }
        for (String el : o2.split("/", 2)) {
            om2.add(el);
        }

        if (!o1.equals(o2)) {
            if (om1.get(0).compareTo(om2.get(0)) > 0) {
                if (om2.get(1).compareTo(om2.get(1)) > 0) {
                    result = 1;
                } else {
                    result = -1;
                }
            } else if (om1.get(0).compareTo(om2.get(0)) < 0) {
                if (om2.get(1).compareTo(om2.get(1)) > 0) {
                    result = 1;
                } else {
                    result = -1;
                }
            }

        }
        return result;
    }
}

//Метод compare должен возвращать 0, 1 или -1. Исходя из этого внутри метода надо придумать нужную логику.


// В этом случае сортировка имеет сложный вид.
// Нам нужн,о сравнить первые элементы по убывания, если они равны, то сравнить последующие элементы, но в возрастающем порядке.

// Сортировка по убыванию:
//
//"K2"
//"K2/SK1"
//"K2/SK1/SSK1"
//"K2/SK1/SSK2"
//
//"K1"
//"K1/SK1"
//"K1/SK1/SSK1"
//"K1/SK1/SSK2"
//"K1/SK2"
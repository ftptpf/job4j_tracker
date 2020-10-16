package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Departments {
    /**
     * Метод добавляет пропущенные наименования департаментов "K*, SK*" и сортирует их в прямой последоательности.
     * @param deps
     * @return
     */
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start + el;
                tmp.add(start);
                start = start + "/";

            }
        }
        List<String> rsl= new ArrayList<>(tmp);
        sortAsc(rsl);
        return rsl;
    }

    /**
     * Метод сортирует в прямой последовательности.
     * @param orgs
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /**
     * Метод сортирует в обратной последовательности. Сложная сортировка.
     * Первая часть фразы обратная последовательность, вторая пряма.
     * @param orgs
     */
    public static void sortDesc(List<String> orgs) {
        //orgs.sort(Comparator.reverseOrder());
        orgs.sort(new DepDescComp());

    }
}

// Чтобы реализовать метод fillGaps, нужно определить, какие элементы отсутствуют в системе.
// Для этого можно использовать метод String.split("/").
// Этот метод вернет массив одиночных элементов.
// Далее нужно через цикл последовательно складывать элементы и добавлять из в множество.
// Используйте в качестве промежуточного хранения HashSet.

// Промежуточная коллекция HashSet позволяет устранить ,дубликаты из коллекции,
// которые будут получаться в результате последовательного складывания единичных департаментов.
// Так же в задаче требуется реализовать возможность сортировки массива кодов подразделений по возрастанию и убыванию,
// при которых сохранялась бы иерархическая структура.

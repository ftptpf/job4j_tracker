package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    /**
     * Сортировка по имени по убыванию.
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}

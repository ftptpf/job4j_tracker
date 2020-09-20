package ru.job4j.collection;

import java.util.Comparator;

public class JobIncreaseByName implements Comparator<Job> {
    /**
     * Сортировка по имени по возрастанию.
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

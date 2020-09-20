package ru.job4j.collection;

import java.util.Comparator;

public class JobIncreaseByPriority implements Comparator<Job> {
    /**
     * Сортировка по приоритету по возрастанию.
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}

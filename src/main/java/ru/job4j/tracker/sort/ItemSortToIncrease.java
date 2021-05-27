package ru.job4j.tracker.sort;

import ru.job4j.tracker.Item;

import java.util.Comparator;

/**
 * Сортировка данных по возрастанию.
 */
public class ItemSortToIncrease implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}

package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * Метод добавления заявки. Добавляет заявку, переданную в аргументах в массив заявок item.
     * @param item
     * @return
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Метод получения списка всех заявок. Возращает копию массива item без null элементов (без пустых значений).
     * @return
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Метод списка по имени. Проверяет в цикле все элементы массива item, сравнивая name.
     * Элементы у которых совпадает name - копирует в результирующий массив и возвращает его.
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        Item[] nameWithoutNull = new Item[size];
        int i = 0;
        for (int index = 0; index < size; index++) {
            Item data = items[index];
            if (data.getName().equals(key)) {
                nameWithoutNull[i] = data;
                i++;
            }
        }
        nameWithoutNull = Arrays.copyOf(nameWithoutNull, size);
        return  nameWithoutNull;
    }

    /**
     * Метод получения заявки по id. Проверяет в цикле все элементы массива item,
     * сравнивая id с аргументом int id и возвращает найденный item. Если Item не найден - возвращает null.
     * @param id
     * @return
     */
     public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
         return index != -1 ? items[index] : null;
    }
    /**
     * Метод замены заявки. Удаляем существующую заявку и в эту же ячейку новую. id остается прежним.
     * @param id
     * @param item
     * @return
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id); // Находим index ячейки по id.
        if (index != -1) { //Если индекс найден
            items[index].setName(item.getName()); //соответствующей ячейке массива items через сеттер присваиваем name из входного параметра item
            items[index].setId(id); // той же ячейке можем присвоить и id, но наверное это не будет иметь смысл,
            // так как id у нас при замене не меняется.
            return true; // условие выполнено возвращаем true
        }
        return false; // условие не выполнено, индекс ячейки не найден по id, возвращаем false
    }


    /**
     * Метод возврата index по id.
     * @param id
     * @return
     */
    private int indexOf(int id) {
         int rls = -1;
         for (int index = 0; index < size; index++) {
             if (items[index].getId() == id) {
                 rls = index;
                 break;
             }
         }
         return rls;
    }
}
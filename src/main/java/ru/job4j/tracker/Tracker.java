package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1; //используется для генерации нового id
    private int size = 0; //размер массива без null элементов

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
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    /**
     * Метода удаления заявки (запись в ячейку null), со сдвиго массива.
     * @param id
     * @return
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        items[index] = null;
        int start = index++;
        int distPos = index;
        int length = size - index;
        items[size - 1] = null;
        size--;
        System.arraycopy(items, start, items, distPos, length);
        return true;
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
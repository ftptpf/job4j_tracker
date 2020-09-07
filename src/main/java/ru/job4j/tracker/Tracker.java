package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {

    // private final Item[] items = new Item[100]; // ----  делаем правки на на java.util.ArrayList
    private final List<Item> items = new ArrayList<>();
    private int ids = 1; //используется для генерации нового id
    private int size = 0; //размер массива без null элементов

    /**
     * Метод добавления заявки. Добавляет заявку, переданную в аргументах в массив заявок item.
     * @param item
     * @return
     */
    public Item add(Item item) {
        item.setId(ids++);// создаем и устанавливаем новый id
        //items[size++] = item;
        items.add(item); // добавляем item в списочный массив ArrayList
        return item;
    }

    /**
     * Метод получения списка всех заявок. Возращает копию массива item без null элементов (без пустых значений).
     * @return
     */
    //public Item[] findAll() { // ----  делаем правки на на java.util.ArrayList
    public List<Item> findAll() {
        //return Arrays.copyOf(items, size);
        return items;
    }

    /**
     * Метод поиска по имени. Проверяет в цикле все элементы массива item, сравнивая name.
     * Элементы у которых совпадает name - копирует в результирующий массив и возвращает его.
     * @param key
     * @return
     */
    //public Item[] findByName(String key) { // ----  делаем правки на на java.util.ArrayList
     public List<Item> findByName(String key) {
        //Item[] nameWithoutNull = new Item[size];
        List<Item> nameWithoutNull = new ArrayList<>();
        int i = 0;
        //for (int index = 0; index < size; index++) {
         for (int index = 0; index < items.size(); index++) {
            //Item data = items[index];
            Item data = items.get(index);
            if (data.getName().equals(key)) {
                //nameWithoutNull[i] = data;
                nameWithoutNull.add(i, data);
                i++;
            }
        }
        //nameWithoutNull = Arrays.copyOf(nameWithoutNull, i);
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
         //return index != -1 ? items[index] : null;
         return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод замены заявки. Удаляем существующую заявку и в эту же ячейку новую. id остается прежним.
     * @param id
     * @param item
     * @return
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if (rls) {
            item.setId(id);
            //items[index] = item;
            items.set(index, item);
        }
        return rls;
    }

    /**
     * Метода удаления заявки (запись в ячейку null), со сдвиго массива.
     * @param id
     * @return
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if (rls) {
            //int start = index + 1;
            //int distPos = index;
            //int length = size - index;
            //System.arraycopy(items, start, items, distPos, length);
            //items[size - 1] = null;
            items.remove(index);
            //size--;
        }
        return rls;
    }

    /**
     * Метод возврата index по id.
     * @param id
     * @return
     */
    private int indexOf(int id) {
         int rls = -1;
         //for (int index = 0; index < size; index++) {
        for (int index = 0; index < items.size(); index++) {
             //if (items[index].getId() == id) {
             if (items.get(index).getId() == id) {
                 rls = index;
                 break;
             }
         }
         return rls;
    }
}
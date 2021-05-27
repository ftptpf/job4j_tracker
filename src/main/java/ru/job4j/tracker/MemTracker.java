package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Работа с заявками, которые хранятся в памяти.
 */
public class MemTracker {

    private final List<Item> items = new ArrayList<>();
    private int ids = 1; //используется для генерации нового id

    /**
     * Метод добавления заявки. Добавляет заявку, переданную в аргументах в массив заявок item.
     * @param item
     * @return
     */
    public Item add(Item item) {
        item.setId(ids++); // создаем и устанавливаем новый id
        items.add(item); // добавляем item в списочный массив ArrayList
        return item;
    }

    /**
     * Метод получения списка всех заявок. Возращает копию массива item без null элементов (без пустых значений).
     * @return
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод поиска по имени. Проверяет в цикле все элементы массива item, сравнивая name.
     * Элементы у которых совпадает name - копирует в результирующий массив и возвращает его.
     * @param key
     * @return
     */
     public List<Item> findByName(String key) {
        List<Item> nameWithoutNull = new ArrayList<>();

         for (int index = 0; index < items.size(); index++) {
            Item data = items.get(index);
            if (data.getName().equals(key)) {
                nameWithoutNull.add(data);
            }
        }
        return  nameWithoutNull;
    }

    /**
     * Метод получения заявки по id. Проверяет в цикле все элементы массива item,
     * сравнивая id с аргументом int id и возвращает найденный item. Если Item не найден - возвращает null.
     * @param id
     * @return
     */
     public Item findById(int id) {
        int index = indexOf(id); //Находим индекс
        return index != -1 ? items.get(index) : null; //Если индекс найден возвращаем item, иначе null
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
            items.remove(index);
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
        for (int index = 0; index < items.size(); index++) {
             if (items.get(index).getId() == id) {
                 rls = index;
                 break;
             }
         }
         return rls;
    }
}
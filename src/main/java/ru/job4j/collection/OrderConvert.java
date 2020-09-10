package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    /**
     * Метод преобразует список заявок в карту.
     * В качестве ключа испольуется поле number.
     * @param orders
     * @return
     */
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order one : orders) {
            map.put(one.getNumber(), one);
        }
        return map;
    }
}

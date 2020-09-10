package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> user = new HashMap<>();
        user.put("test@test.ru", "Boyko Andrey");
        for (String info : user.keySet()) {
            String value = user.get(info);
            System.out.println(value);
        }
    }
}

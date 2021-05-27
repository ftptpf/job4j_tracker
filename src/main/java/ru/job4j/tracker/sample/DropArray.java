package ru.job4j.tracker.sample;

import java.util.Arrays;

public class DropArray {
    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Stepan", null};
        String[] namesWithoutNulls = new String[names.length];
        int size = 0;
        for (int index = 0; index < names.length; index++) {
            String name = names[index];
            if (name != null) {
                namesWithoutNulls[size] = name;
                size++;
            }
        }
        namesWithoutNulls = Arrays.copyOf(namesWithoutNulls, size);
        for (int index = 0; index < namesWithoutNulls.length; index++) {
            System.out.println(namesWithoutNulls[index]);
        }
    }
}

package ru.job4j.ex;

public class Find {
    public static String get(String[] data, int index) {
        if (index < 0 || index > data.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Index out of bound");
        }
        return data[index];
    }

    public static void main(String[] args) {
        String[] data = {"one", "two", "three"};
        String rls = Find.get(data, -1);
        System.out.println(rls);
    }
}

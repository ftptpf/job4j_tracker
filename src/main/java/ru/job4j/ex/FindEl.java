package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rls = -1;
        for (int index = 0; index < value.length; index++) {
            String k = value[index];
            if (k.equals(key)) {
                rls = index;
                break;
            }
        }
        if (rls == -1) {
            throw new ElementNotFoundException("The string not found. Try other one.");
        }
        return rls;

    }
    public static void main(String[] args) {
        String[] array = {"One", "Two", "Three", "Two"};
        String in = "Two";
        try {
            indexOf(array, in);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

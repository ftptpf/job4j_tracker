package ru.job4j.max;

public class Reduce {
    private int[] ar;
    public void to(int[] array) {
        ar = array;
    }
    public void print() {
        for (int index = 0; index < ar.length; index++) {
            System.out.println(ar[index]);
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}

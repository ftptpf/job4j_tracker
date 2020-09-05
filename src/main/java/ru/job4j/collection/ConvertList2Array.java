package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    /**
     * Метод преобразует одномерный список в двухмерный массив.
     * @param list список int
     * @param cells число элементов в группе
     * @return массив
     */
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells); // определение количества групп
        // с округлением в большую сторону
        int [][] array = new int[groups][cells];
        int row = 0, cell = 0; // инициализация строки и ячейки
        for (Integer num : list) {
            array[row][cell] = num;
            cell = cell + 1;
            if (cell == 3) {
                row = row + 1;
                cell = 0;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int [][] rls = toArray(list, 3);
        for (int[] row : rls) {
            for (int cell : row) {
                System.out.println(cell + " ");
            }
            System.out.println();
        }
    }
}

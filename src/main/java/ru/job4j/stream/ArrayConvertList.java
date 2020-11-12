package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayConvertList {
    /**
     * Метод преобразует матрицу в список чисел.
     * @param integersArray
     * @return
     */
    public static List<Integer> arrayConvertToList(Integer[][] integersArray) {
        return Stream.of(integersArray)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}

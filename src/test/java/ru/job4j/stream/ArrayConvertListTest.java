package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayConvertListTest {

    @Test
    public void arrayConvertToList() {
        Integer [][] arInt = {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> result = ArrayConvertList.arrayConvertToList(arInt);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expected));
    }
}
package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaximumTest {

    @Test
    public void maxTwo() {
        int result = Maximum.max(3, 5);
        assertThat(result, is(5));
    }
    @Test
    public void maxThree() {
        int result = Maximum.max(4, 8, 6);
        assertThat(result, is(8));
    }
    @Test
    public void maxFour() {
        int result = Maximum.max(10, 1, 1,  4);
        assertThat(result, is(10));
    }
}
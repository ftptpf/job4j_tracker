package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMaxSecond() {
        assertThat(Max.max(1,2), is(2));
    }
    @Test
    public void whenMaxFirst() {
        assertThat(Max.max(2,1), is(2));
    }
    @Test
    public void whenEquals() {
        assertThat(Max.max(2,2), is(2));
    }
    //@Test
    //public void whenNegativeNumber() {
       // assertThat(Max.max(-2,-1), is(-1));
    //}
}
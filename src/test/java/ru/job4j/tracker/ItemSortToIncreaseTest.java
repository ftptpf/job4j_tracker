package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSortToIncreaseTest {

    @Test
    public void compareToIncrease() {
        Item one = new Item();
        one.setName("test1");
        Item two = new Item();
        two.setName("test2");
        ItemSortToIncrease it = new ItemSortToIncrease();
        assertThat(it.compare(one, two), is(-1));
    }
}
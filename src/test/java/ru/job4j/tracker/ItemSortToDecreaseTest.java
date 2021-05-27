package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.sort.ItemSortToDecrease;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSortToDecreaseTest {

    @Test
    public void compareToDecrease() {
        Item one = new Item();
        one.setName("test1");
        Item two = new Item();
        two.setName("test2");
        ItemSortToDecrease it = new ItemSortToDecrease();
        assertThat(it.compare(one, two), is(1));
    }
}
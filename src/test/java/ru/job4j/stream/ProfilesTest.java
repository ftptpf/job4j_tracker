package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Address> list = new ArrayList<>();

    @Before
    public void setUp() {
        list.add(new Address("Moscow", "Red", 1, 3));
        list.add(new Address("Samara", "Long", 11, 36));

    }
    @Test
    public void collect() {
        List<Profile> pr = new ArrayList<>();
        pr.add(new Profile(new Address("Moscow", "Red", 1, 3)));
        pr.add(new Profile(new Address("Samara", "Long", 11, 36)));
        Profiles r = new Profiles();
        List<Address> rsl = r.collect(pr);
        assertThat(rsl, is(list));
    }

    @Test
    public void collectSortDouble() {
        List<Profile> pr = new ArrayList<>();
        pr.add(new Profile(new Address("Samara", "Long", 11, 36)));
        pr.add(new Profile(new Address("Moscow", "Red", 1, 3)));
        pr.add(new Profile(new Address("Samara", "Long", 11, 36)));
        Profiles r = new Profiles();
        List<Address> rsl = r.collect(pr);
        assertThat(rsl, is(list));
    }
}
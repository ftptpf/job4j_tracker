package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Students> input = new ArrayList<>();
        input.add(new Students("Masha", 28));
        input.add(new Students("Pety", 128));
        List<Students> expected = List.of(
                new Students("Pety", 128),
                new Students("Masha", 28)
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Students> input = new ArrayList<>();
        input.add( null);
        List<Students> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Students> input = new ArrayList<>();
        input.add( null);
        input.add(new Students("Pety",28));
        List<Students> expected = List.of(new Students("Pety",28));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }
}
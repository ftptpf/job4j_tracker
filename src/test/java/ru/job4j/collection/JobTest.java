package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class JobTest {

    /**
     * Тест сортировки по имени (по убыванию) и по приоритету (по убыванию).
     */
    @Test
    public void whenCompatorByNameAndProrityDec() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B task", 0),
                new Job("A bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    /**
     * Тест сортировки по имени (по возрастанию) и по приоритету (по возрастанию).
     */
    @Test
    public void whenCompatorByNameAndProrityIncr() {
        Comparator<Job> cmpNamePriority = new JobIncreaseByName().thenComparing(new JobIncreaseByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B task", 0),
                new Job("A bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
    /**
     * Тест сортировки по имени (по убыванию).
     */
    @Test
    public void whenCompatorByNameDec() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("B task", 0),
                new Job("A bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    /**
     * Тест сортировки по имени (по возрастанию).
     */
    @Test
    public void whenCompatorByNameIncr() {
        Comparator<Job> cmpNamePriority = new JobIncreaseByName();
        int rsl = cmpNamePriority.compare(
                new Job("B task", 0),
                new Job("A bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    /**
     * Тест сортировки по приоритету (по убыванию).
     */
    @Test
    public void whenCompatorByProrityDec() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("B task", 0),
                new Job("A bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    /**
     * Тест сортировки по приоритету (по возростанию).
     */
    @Test
    public void whenCompatorByProrityIncr() {
        Comparator<Job> cmpNamePriority = new JobIncreaseByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("B task", 0),
                new Job("A bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }


}
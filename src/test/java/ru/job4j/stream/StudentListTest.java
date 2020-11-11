package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentListTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Nikolaev"));
        students.add(new Student(20, "Semenov"));
        students.add(new Student(30, "Gordeev"));
    }

    @Test
    public void whenConvertListToMap() {
        StudentList sl = new StudentList();
        Map<String, Integer> result = sl.convertToMap(students);
        Map<String, Integer> exp = new TreeMap<>();
        exp.put("Nikolaev", 10);
        exp.put("Semenov", 20);
        exp.put("Gordeev", 30);
        assertThat(exp, is(result));
    }
}
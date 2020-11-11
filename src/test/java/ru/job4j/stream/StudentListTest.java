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
        students.add(new Student(90, "Gordeev"));
    }

    @Test
    public void whenConvertListToMap() {
        StudentList sl = new StudentList();
        Map<String, Student> result = sl.convertToMap(students);
        Map<String, Student> exp = new TreeMap<>();
        exp.put("Nikolaev", new Student(10, "Nikolaev"));
        exp.put("Semenov", new Student(20, "Semenov"));
        exp.put("Gordeev", new Student(90, "Gordeev"));
        assertThat(exp, is(result));
    }
}
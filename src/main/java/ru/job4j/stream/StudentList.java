package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentList {
    Map<String, Integer> convertToMap(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(Student::getSurname, Student::getScore));
    }
}

package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentList {
    Map<String, Student> convertToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getSurname, st -> st, (oldOne, newOne) -> newOne));
    }
}

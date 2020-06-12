package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Sergey Petrovich");
        student.setGroup(44);
        student.setStart(new Date());
        System.out.println(student.getFio() + " from group №" + student.getGroup() +
                " is start study in " + student.getStart());
    }
}

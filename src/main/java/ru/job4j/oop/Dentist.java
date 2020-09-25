package ru.job4j.oop;

public class Dentist extends Doctor {
    private int tooth;

    public Dentist() {

    }
    public Dentist(int tooth, String education) {
        this.tooth = tooth;
        super.education = education;
    }

    public void drill(int tooth) {

    }
    public void tear(int tooth) {

    }
}

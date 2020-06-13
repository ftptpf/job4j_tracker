package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cc = new Book("Clean Code.", 400);
        Book sch = new Book("Java Complete Reference.", 1500);
        Book sr = new Book("Java Head First.", 500);
        Book ex = new Book("JAVA exercises.", 250);

        Book[] books = new Book[4];
        books[0] = cc;
        books[1] = sch;
        books[2] = sr;
        books[3] = ex;

        for(int index = 0; index < books.length; index++) {
            Book bi = books[index];
            System.out.println(bi.getName() + " - " + bi.getPage() + " pages");
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for(int index = 0; index < books.length; index++) {
            Book bi = books[index];
            System.out.println(bi.getName() + " - " + bi.getPage() + " pages");
        }
        for(int index = 0; index < books.length; index++) {
            Book bi = books[index];
            if(bi.equals(cc)) {
            System.out.println(bi.getName() + " - " + bi.getPage() + " pages");
            }
        }
    }
}

package ru.job4j.oop;

public class DummyDic {
    public static String engToRus(String eng) {
        String text = "Неизвестное слово. "  + eng;
        return text;
    }
    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        System.out.println(dic.engToRus("TomTaylor"));
    }
}

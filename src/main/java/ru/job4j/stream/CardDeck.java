package ru.job4j.stream;

import java.util.stream.Stream;

public class CardDeck {
    /**
     * Метод генерирует колоду карт.
     * @param args
     */
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> s + " " + v))
                .forEach(System.out::println);
    }
}

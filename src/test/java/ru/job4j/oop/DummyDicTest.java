package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class DummyDicTest {

    @Test
    public void sendWorldsToEngToRus() {
        String input = "TomTaylor";
        String result = DummyDic.engToRus(input);
        String expected = "Неизвестное слово. TomTaylor";
        assertThat(result, is(expected));
    }
}
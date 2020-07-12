package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item();
        expected.setName("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("some name");
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId()), "replace item"};
        StartUI.replaceItem(new StubInput(answer), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replace item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker(); // Создаем объект Tracker
        Item item = new Item(); // Создаем объект Item
        item.setName("some name"); // Записываем в Item параметр name
        tracker.add(item); // Добавляем Item в Tracker
        String[] answer = {String.valueOf(item.getId()), "some item"}; // В строковый массив записываем значение
        StartUI.deleteItem(new StubInput(answer), tracker); // Иммитируем пользовательский ввод с
        // с переданными в input параметрами строкового массива answer
        Item delete = tracker.findById(item.getId()); // Запускаем поиск удаленного Item по id
        assertThat(delete, is("null")); // Сравниваем результат и ожидание
    }
}
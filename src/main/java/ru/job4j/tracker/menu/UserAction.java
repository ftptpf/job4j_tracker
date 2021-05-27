package ru.job4j.tracker.menu;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Store;

/**
 * Интерфейс выполнеия действий с заявкой.
 */
public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}

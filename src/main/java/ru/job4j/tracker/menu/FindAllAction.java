package ru.job4j.tracker.menu;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.List;

/**
 * Находим все заявки.
 */
public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items.";
    }
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== All Items ===");
        List<Item> item = tracker.findAll();
        for (int i = 0; i < item.size(); i++) {
            out.println(item.get(i));
        }
        return true;
    }
}

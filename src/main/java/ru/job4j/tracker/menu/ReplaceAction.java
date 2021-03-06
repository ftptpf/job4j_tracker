package ru.job4j.tracker.menu;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

/**
 * Изменяем заявку.
 */
public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item.";
    }
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit (replace) item ===");
        int id = Integer.valueOf(input.askInt("Enter id: "));
        String name = input.askStr("Enter new Name: ");
        Item newItem = new Item();
        newItem.setName(name);
        if (tracker.replace(id, newItem)) {
            out.println("Replacement was done.");
        } else {
            out.println("Replacement error.");
        }
        return true;
    }
}

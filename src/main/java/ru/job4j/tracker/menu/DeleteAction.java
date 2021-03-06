package ru.job4j.tracker.menu;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Store;

/**
 * Удаляем заявку.
 */
public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item.";
    }
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ===");
        int id = Integer.valueOf(input.askInt("Enter id: "));
        if (tracker.delete(id)) {
            out.println("Delete is Ok.");
        } else {
            out.println("Delete error.");
        }
        return true;
    }
}

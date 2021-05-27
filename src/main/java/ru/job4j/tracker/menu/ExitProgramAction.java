package ru.job4j.tracker.menu;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Store;

/**
 * Завершаем программу.
 */
public class ExitProgramAction implements UserAction {
    private final Output out;

    public ExitProgramAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit Program.";
    }
    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}

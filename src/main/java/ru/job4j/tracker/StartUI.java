package ru.job4j.tracker;


import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.menu.*;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * Инициализирует приложение и запускает выполнение различных пользовательских действий.
     * @param input
     * @param tracker
     * @param actions
     */
    public void init(Input input, Store tracker, List<UserAction> actions) {
        tracker.init(); //  инициализироуем соединение с postgresql базой items
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select:");
            if (select < 0 || select > actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
                UserAction action = actions.get(select);
                run = action.execute(input, tracker);
        }
    }

    /**
     * Выводит на экран меню доступных пользовательских действий.
     * @param actions
     */
    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store tracker = new SqlTracker(init());

        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new FindAllAction(output));
        actions.add(new ReplaceAction(output));
        actions.add(new DeleteAction(output));
        actions.add(new FindAllByIdAction(output));
        actions.add(new FindByNameAction(output));
        actions.add(new ExitProgramAction(output));

        new StartUI(output).init(input, tracker, actions);
    }
}

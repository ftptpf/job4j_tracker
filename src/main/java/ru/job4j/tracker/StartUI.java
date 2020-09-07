package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    //public void init(Input input, Tracker tracker, UserAction[] actions) {
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select:");
            //if(select < 0 || select > actions.length) {
            if(select < 0 || select > actions.size()) {
                //out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
                //UserAction action = actions[select];
                UserAction action = actions.get(select);
                run = action.execute(input, tracker);
        }
    }

    //private void showMenu(UserAction[] actions) {
    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        //for (int index = 0; index < actions.length; index++) {
        for (int index = 0; index < actions.size(); index++) {
            //out.println(index + ". " +actions[index].name());
            out.println(index + ". " +actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        /*UserAction[] actions = {
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindAllByIdAction(output),
                new FindByNameAction(output),
                new ExitProgramAction(output)
        };
         */
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

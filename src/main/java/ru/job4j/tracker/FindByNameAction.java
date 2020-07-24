package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name.";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        Item[] n = tracker.findByName(name);
        if (n.length == 0) {
            out.println("Error. We can't find result.");
        } else {
            for(int i = 0; i < n.length; i++) {
                out.println(n[i]);
            }
        }
        return true;
    }
}

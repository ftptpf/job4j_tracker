package ru.job4j.tracker;

import java.util.List;

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
        //Item[] n = tracker.findByName(name);
        List<Item> n = tracker.findByName(name);
        //if (n.length == 0) {
        if (n.size() == 0) {
            out.println("Error. We can't find result.");
        } else {
            //for(int i = 0; i < n.length; i++) {
            for(int i = 0; i < n.size(); i++) {
                //out.println(n[i]);
                out.println(n.get(i));
            }
        }
        return true;
    }
}

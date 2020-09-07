package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction{
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items.";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== All Items ===");
        //Item[] item = tracker.findAll();
        List<Item> item = tracker.findAll();
        //for (int i = 0; i < item.length; i++) {
        for (int i = 0; i < item.size(); i++) {
            //out.println(item[i]);
            out.println(item.get(i));
        }
        return true;
    }
}

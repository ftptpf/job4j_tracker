package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "Find items by name.";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] n = tracker.findByName(name);
        if (n.length == 0) {
            System.out.println("Error. We can't find result.");
        } else {
            for(int i = 0; i < n.length; i++) {
                System.out.println(n[i]);
            }
        }
        return true;
    }
}

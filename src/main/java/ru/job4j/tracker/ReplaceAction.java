package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    @Override
    public String name() {
        return "Edit item.";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Enter id: "));
        String name = input.askStr("Enter new Name: ");
        Item newItem = new Item();
        newItem.setName(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Replacement was done.");
        } else {
            System.out.println("Replacement error.");
        }
        return true;
    }
}

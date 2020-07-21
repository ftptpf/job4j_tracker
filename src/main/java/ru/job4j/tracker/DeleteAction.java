package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "Delete item.";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Delete is Ok.");
        } else {
            System.out.println("Delete error.");
        }
        return true;
    }
}

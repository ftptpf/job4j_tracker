package ru.job4j.tracker;

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

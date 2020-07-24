package ru.job4j.tracker;

public class FindAllByIdAction implements UserAction{
    private final Output out;

    public FindAllByIdAction(Output out) {
        this.out = out;
    }
    @Override
    public String name(){
        return "Find item by Id.";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by id ===");
        int id = Integer.valueOf(input.askInt("Enter id: "));
        Item t = tracker.findById(id);
        if (t == null) {
            out.println("Error. Item is null");
        }else {
            out.println(t);
        }
        return true;
    }
}

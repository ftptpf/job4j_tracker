package ru.job4j.tracker;

public class FindAllByIdAction implements UserAction{
    @Override
    public String name(){
        return "Find item by Id.";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Enter id: "));
        Item t = tracker.findById(id);
        if (t == null) {
            System.out.println("Error. Item is null");
        }else {
            System.out.println(t);
        }
        return true;
    }
}

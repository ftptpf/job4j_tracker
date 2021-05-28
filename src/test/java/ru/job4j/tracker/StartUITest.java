package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.other.StubInput;
import ru.job4j.tracker.menu.*;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.other.StubOutput;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final String br = System.lineSeparator();

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Store tracker = new SqlTracker();
        //tracker.init();

        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitProgramAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = new Item();
        item.setName("Replaced item");
        tracker.add(item);
        String replacedName = "New item name";
        String nameNew = item.getId() + " " + replacedName;
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitProgramAction(out));

        new StartUI(out).init(in, tracker, actions);
        String nameNewResult = String.valueOf(tracker.findById(item.getId()));
        assertThat(nameNewResult, is(nameNew));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = new Item();
        item.setName("Deleted item");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitProgramAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Store tracker = new SqlTracker();

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + br
                        + "0. Exit Program." + br));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item1 = new Item();
        item1.setName("One");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("Two");
        tracker.add(item2);
        Input in = new StubInput(
                new String[] {"0", "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(out));
        actions.add(new ExitProgramAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + br
                        + "0. Show all items." + br
                        + "1. Exit Program." + br
                        + "=== All Items ===" + br
                        + "1 One" + br
                        + "2 Two" + br
                        + "Menu." + br
                        + "0. Show all items." + br
                        + "1. Exit Program." + br));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item1 = new Item();
        item1.setName("One");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("Two");
        tracker.add(item2);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item1.getId()), "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllByIdAction(out));
        actions.add(new ExitProgramAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + br
                        + "0. Find item by Id." + br
                        + "1. Exit Program." + br
                        + "=== Find item by id ===" + br
                        + "1 One" + br
                        + "Menu." + br
                        + "0. Find item by Id." + br
                        + "1. Exit Program." + br));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item1 = new Item();
        item1.setName("One");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("Two");
        tracker.add(item2);
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item1.getName()), "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitProgramAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + br
                        + "0. Find items by name." + br
                        + "1. Exit Program." + br
                        + "=== Find item by name ===" + br
                        + "1 One" + br
                        + "Menu." + br
                        + "0. Find items by name." + br
                        + "1. Exit Program." + br));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"9", "0"}
                );
        Store tracker = new SqlTracker();

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + br
                        + "0. Exit Program." + br
                        + "Wrong input, you can select: 0 .. 0" + br
                        + "Menu." + br
                        + "0. Exit Program." + br));
    }
}
package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.other.StubInput;
import ru.job4j.tracker.menu.*;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.other.StubOutput;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;


public class StartUITest {
    private final String br = System.lineSeparator();
    private String nameOne = "One";
    private String nameTwo = "Two";

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenAddItem() throws Exception {
/*        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Store tracker = new SqlTracker();

        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitProgramAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));*/
        //SqlTracker tracker = new SqlTracker();
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item();
            item.setName(nameOne);
            tracker.add(item);
            assertThat(tracker.findByName(nameOne).size(), is(1));
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
/*        Output out = new StubOutput();
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
        assertThat(nameNewResult, is(nameNew));*/

        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item itemOne = new Item();
            itemOne.setName(nameOne);
            tracker.add(itemOne);
            assertThat(tracker.findByName(nameOne).size(), is(1));
            Item itemTwo = new Item();
            itemTwo.setName(nameTwo);
            tracker.replace(itemOne.getId(), itemTwo);
            assertThat(tracker.findByName(nameOne).size(), is(0));
            assertThat(tracker.findByName(nameTwo).size(), is(1));
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
/*        Output out = new StubOutput();
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
        assertThat(tracker.findById(item.getId()), is(nullValue()));*/
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item itemOne = new Item();
            itemOne.setName(nameOne);
            tracker.add(itemOne);
            assertThat(tracker.findByName(nameOne).size(), is(1));
            tracker.delete(itemOne.getId());
            assertThat(tracker.findByName(nameOne).size(), is(0));
        }
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
    public void whenFindAll() throws Exception {
/*        Output out = new StubOutput();
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
                        + "1. Exit Program." + br));*/
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item itemOne = new Item();
            itemOne.setName(nameOne);
            tracker.add(itemOne);
            Item itemTwo = new Item();
            itemTwo.setName(nameTwo);
            tracker.add(itemTwo);

            List<Item> controlList = new ArrayList<>();
            controlList.add(itemOne);
            controlList.add(itemTwo);

            List<Item> list = tracker.findAll();
            assertTrue(list.containsAll(controlList));
            assertThat(tracker.findByName(nameOne).size(), is(1));
            assertThat(tracker.findByName(nameTwo).size(), is(1));
        }
    }

    @Test
    public void whenFindById() {
/*        Output out = new StubOutput();
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
                        + "1. Exit Program." + br));*/

    }

    @Test
    public void whenFindByName() {
/*        Output out = new StubOutput();
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
                        + "1. Exit Program." + br));*/

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
package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.other.StubInput;
import ru.job4j.tracker.menu.*;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.other.StubOutput;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
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
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item();
            item.setName(nameOne);
            tracker.add(item);
            assertThat(tracker.findByName(nameOne).size(), is(1));
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
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
    public void whenFindById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item itemOne = new Item();
            itemOne.setName(nameOne);
            tracker.add(itemOne);
            assertThat(tracker.findById(itemOne.getId()), is(itemOne));
        }
    }

    @Test
    public void whenFindByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item itemOne = new Item();
            itemOne.setName(nameOne);
            tracker.add(itemOne);

            Item itemTwo = new Item();
            itemTwo.setName(nameTwo);
            tracker.add(itemTwo);
            assertThat(tracker.findByName(nameOne).size(), is(1));

            Item itemOneExtra = new Item();
            itemOneExtra.setName(nameOne);
            tracker.add(itemOneExtra);
            assertThat(tracker.findByName(nameOne).size(), is(2));
        }
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
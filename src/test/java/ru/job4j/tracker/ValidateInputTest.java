package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final String br = System.lineSeparator();

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }
    @Test
    public void whenCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }
    @Test
    public void whenCheckOutput() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitProgramAction(out)
        };
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + br +
                        "0. Show all items." + br +
                        "1. Exit Program." + br));
    }
}
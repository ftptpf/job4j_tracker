package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.other.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.menu.ExitProgramAction;
import ru.job4j.tracker.menu.FindAllAction;
import ru.job4j.tracker.menu.UserAction;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.other.StubOutput;

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
        Input in = new StubInput(
                new String[] {"zzzzzzzzzzz", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitProgramAction(out)
        };
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(out.toString(), is("Please enter validate data again." + br));
    }
}
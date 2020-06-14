package ru.job4j.pojo;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setModel("audio");
        License second = new License();
        second.setModel("audio");
        assertThat(first, is(second));
    }
}
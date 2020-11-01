package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Petr", "Nikolaev", "6565489", "Saratov")
        );
        phones.add(
                new Person("Igor", "Petrov", "2432489", "Izevsk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }
}
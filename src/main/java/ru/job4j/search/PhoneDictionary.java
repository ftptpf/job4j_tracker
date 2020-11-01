package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {

        Predicate<Person> pn = (x) -> x.getName().contains(key);
        Predicate<Person> ps = (x) -> x.getSurname().contains(key);
        Predicate<Person> pp = (x) -> x.getPhone().contains(key);
        Predicate<Person> pa = (x) -> x.getAddress().contains(key);
        Predicate<Person> combine = (x) -> pn.or(ps).or(pp).or(pa).test(x);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}

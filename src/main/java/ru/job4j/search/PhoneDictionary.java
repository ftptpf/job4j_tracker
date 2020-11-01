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
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                    Predicate<Person> pn = (x) -> x.getName().equals(person.getName());
                    Predicate<Person> ps = (x) -> x.getSurname().equals(person.getSurname());
                    Predicate<Person> pp = (x) -> x.getPhone().equals(person.getPhone());
                    Predicate<Person> pa = (x) -> x.getAddress().equals(person.getAddress());
                    if (pn.or(ps).or(pp).or(pa).test(person)) {
                        return true;
                }
                return false;
            }
        };

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
         return result;
    };
}

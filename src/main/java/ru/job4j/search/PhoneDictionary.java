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
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                for (int index = 0; index < persons.size(); index++) {
                    String n = persons.get(index).getName();
                    String s = persons.get(index).getSurname();
                    String p = persons.get(index).getPhone();
                    String a = persons.get(index).getAddress();
                    if (n.contains(key) || s.contains(key) || p.contains(key) || a.contains(key)) {
                        return true;
                    }
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


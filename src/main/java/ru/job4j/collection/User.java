package ru.job4j.collection;


import java.util.Objects;

/**
 * Каркас класса.
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Метод сравнивает имена, если они равны - сравнивает возраст.
     */
    @Override
    public int compareTo(User o) {
        int rsl = name.compareTo(o.name); // сравниваем два имени
        if (name.equals(o.name)) { // если имена равны
            rsl = Integer.compare(age, o.age); // сравниваем возраст
        }
        return rsl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

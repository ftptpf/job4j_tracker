package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    /**
     * Метод составляет список адресов клиентов.
     * @param profiles
     * @return
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(x -> x.getAddress())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }
}

package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    /**
     * Метод add вернет true, если пользователя еще нет в HashMap. Если он уже есть, то вернуть false.
     * @param citizen
     * @return
     */
    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод get вернет citizen по номеру паспорта.
     * @param passport
     * @return
     */
    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}

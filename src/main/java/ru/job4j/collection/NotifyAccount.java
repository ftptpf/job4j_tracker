package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    /**
     * Метод позволяет отобрать и оставить только уникальных клиентов для рассылки.
     * @param accounts Список клиентов
     * @return
     */
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account ac : accounts) {
            rsl.add(ac);
        }
        return rsl;
    }
}

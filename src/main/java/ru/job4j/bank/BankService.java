package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет пользователю.
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User findUser = findByPassport(passport); // находим пользователя по номеру паспорта
        if (findUser != null) {
            List<Account> userAccounts = users.get(findUser); // находим список Account-ов пользователя
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     * @param passport
     * @return
     */
    public User findByPassport(String passport) {
        Set<User> set = users.keySet();

        User findUser = set.stream() // создаем поток
                .filter(p -> passport.equals(p.getPassport())) // через фильтр находим пользователя по паспорту
                .findAny() // находим "любое" значение
                .orElse(null); // если значения никакого нет, выводим null

        return findUser;
    }

    /**
     * Метод ищет пользователя по реквизитам.
     * Сначала ищем пользователя. Потом получаем списаок счетов пользователя и находим нужный.
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        Account findAccount = null;
        User findUser = findByPassport(passport); // находим пользователя по номеру паспорта
        if (findUser != null) {
            List<Account> userAccounts = users.get(findUser); // находим список аккаунтов польователя
            findAccount = userAccounts.stream()
                    .filter(r -> requisite.equals(r.getRequisite())) // черех фильтр находим аккаунт по реквизитам
                    .findAny() // берем "любое" значение
                    .orElse(null); // если значения никакого нет, выводим null
        }
        return findAccount;
    }

    /**
     * Метод для перевода денег с одного счета на другой
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount сумма перевода
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (destAccount != null && srcAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance((srcAccount.getBalance() - amount));
            rsl = true;
        }
        return rsl;
    }
}

package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет польлзователя в систему.
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
        User findUser = findByPassport(passport); // находим пльзователя по номеру паспорта
        List<Account> userAccounts = users.get(findUser); // находим список Account-ов пользователя
        if (!userAccounts.contains(account)) {
            userAccounts.add(account);
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     * @param passport
     * @return
     */
    public User findByPassport(String passport) {
        User findUser = new User("000", "NotUser");
        Set<User> set = users.keySet();
        for (User person : set) {
            if(!person.getPassport().isEmpty()); {
                findUser = person;
                break;
            }
        }
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
        List<Account> userAccounts = users.get(findUser); // находим список аккаунтов пользователя
        for (Account a : userAccounts) { //перебираем найденные "Account-ы" пользователя
            if (a.getRequisite().contains(requisite)) { //если реквизиты найдены
                findAccount = a; // возвращаем "Account"
            }
        }
        return findAccount;
    }

    /**
     * Метод для перевода денег с одного счета на другой
     * @param srcPassport паспорт отправилтеля
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
        if (srcAccount != null || amount < srcAccount.getBalance()) {
            destAccount.setBalance(amount + destAccount.getBalance());
            rsl = true;
        }
        return rsl;
    }
}

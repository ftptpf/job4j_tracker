package ru.job4j.bank;

import java.util.*;

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
        Optional<User> findUser = findByPassport(passport); // находим пользователя по номеру паспорта
        if (findUser.isPresent()) {
            List<Account> userAccounts = users.get(findUser.get()); // находим список Account-ов пользователя
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
    public Optional<User> findByPassport(String passport) {
        Optional<User> findUser = Optional.empty();
        findUser = users.keySet().stream()
                .filter(p -> passport.equals(p.getPassport()))
                .findAny();

        return findUser;
    }

    /**
     * Метод ищет пользователя по реквизитам.
     * Сначала ищем пользователя. Потом получаем списаок счетов пользователя и находим нужный.
     * @param passport
     * @param requisite
     * @return
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> findAccount = Optional.empty();
        Optional<User> findUser = findByPassport(passport); // находим пользователя по номеру паспорта
        if (findUser.isPresent()) {
            findAccount = users.get(findUser.get()).stream() // находим список аккаунтов польователя
                    .filter(r -> requisite.equals(r.getRequisite())) // черех фильтр находим аккаунт по реквизитам
                    .findAny();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (destAccount.isPresent() && srcAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            srcAccount.get().setBalance((srcAccount.get().getBalance() - amount));
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> opt = bank.findByPassport("3211");
        if (opt.isPresent()) {
            System.out.println(opt.get().getUsername());
        }
    }
}

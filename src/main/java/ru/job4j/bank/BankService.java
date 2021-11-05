package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс осуществляет работу с клиентами банка и с их счетами
 */
public class BankService {
    /**
     * Хранение клиентов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента, и, если его нет в коллекции с клиентами банка,
     * добавляет его в нее и привязывает к нему пустой список с счетами.
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход номер паспорта и удаляет клиента с идентичным номером
     * из списка клиентов банка, если такой клиент существует.
     * @param passport
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    /**
     * Метод принимает на вход паспорт и счет.
     * Если клиент с таким паспортом существует,
     * происходит добавление счета к списку счетов клиента,
     * если такого счета там еще нет.
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспорта и ищет по нему клиента.
     * @param passport
     * @return возвращает клиента или null, если клиента с таким паспортом не существует.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход номер паспорта и реквизиты счета
     * и ищет счет с такими реквизитами у клиента с таким номером паспорта.
     * @param passport
     * @param requisite
     * @return возвращает счет или null, если клиента с таким паспортом
     * или счета с такими реквизитами не найдено.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход номера паспортов и реквизиты счетов двух клиентов,
     * а также количество валюты.
     * Метод проверяет, есть ли такие счета у клиентов с такими номерами паспортов,
     * и переводит входящее кол-во валюты с первого счета на второй,
     * если все соблюдено.
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return возвращает {@code True}, если перевод осуществился.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account sourceAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = sourceAccount != null && destAccount != null
                && sourceAccount.getBalance() >= amount;
        if (rsl) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }
}
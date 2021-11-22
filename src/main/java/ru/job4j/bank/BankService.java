package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

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
        Optional<User> user = findByPassport(passport);
        user.ifPresent(users::remove);
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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход номер паспорта и реквизиты счета
     * и ищет счет с такими реквизитами у клиента с таким номером паспорта.
     * @param passport
     * @param requisite
     * @return возвращает счет или null, если клиента с таким паспортом
     * или счета с такими реквизитами не найдено.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> sourceAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = sourceAccount.isPresent() && destAccount.isPresent()
                && sourceAccount.get().getBalance() >= amount;
        if (rsl) {
            sourceAccount.get().setBalance(sourceAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        }
        return rsl;
    }
}
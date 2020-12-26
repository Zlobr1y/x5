package ru.titov.course.task7.service;

import ru.titov.course.task7.Account;
import ru.titov.course.task7.dao.Dao;
import ru.titov.course.task7.dao.DaoType;
import ru.titov.course.task7.exception.*;

import java.io.IOException;

public class AccountService implements Service<Account> {
    private final Dao<Account> accountDao;

    public AccountService(Dao<Account> type) {
//        AccountServiceFactory accountDaoFactory = new AccountServiceFactory();
        this.accountDao = type;
    }

    @Override
    public void withdraw(int id, int amount) throws NotEnoughMoneyException, DaoException, IOException, DublicatePrimaryKeyException, AccountException, UnknownAccountException {
        Account thisAccount = accountDao.getById(id);
        if (thisAccount.getBalance() - amount < 0) {
            throw new NotEnoughMoneyException("Account " + thisAccount.getHolder().getName() + " need more gold.");
        }
        thisAccount.setBalance(thisAccount.getBalance() - amount);
        accountDao.update(thisAccount);
    }

    @Override
    public double balance(int id) throws UnknownAccountException, DaoException {
        return accountDao.getById(id).getBalance();
    }

    @Override
    public void deposit(int id, int amount) throws DaoException, IOException, DublicatePrimaryKeyException, AccountException, UnknownAccountException {
        Account thisAccount = accountDao.getById(id);
        thisAccount.setBalance(thisAccount.getBalance() + amount);
        accountDao.update(thisAccount);
    }

    @Override
    public void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException, DaoException, IOException, DublicatePrimaryKeyException, AccountException {
        Account fromAccount = accountDao.getById(from);
        Account toAccount = accountDao.getById(to);

        if (fromAccount.getBalance() - amount <= 0) {
            throw new NotEnoughMoneyException("Account " + fromAccount.getHolder().getName() + " need more gold.");
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountDao.update(fromAccount);
        accountDao.update(toAccount);

    }
}


import dao.Dao;
import dao.DaoType;
import exception.DaoException;
import exception.DublicatePrimaryKeyException;
import exception.NotEnoughMoneyException;
import exception.UnknownAccountException;
import jpa.Account;

import java.io.IOException;

public class AccountService implements Service<Account> {
    private final Dao<Account> accountDao;

    public AccountService(DaoType type) {
        AccountAccountFactory accountDaoFactory = new AccountAccountFactory();
        this.accountDao = accountDaoFactory.getDao(type);
    }

    @Override
    public void withdraw(Account account, int amount) throws NotEnoughMoneyException, UnknownAccountException, DaoException, IOException, DublicatePrimaryKeyException {
        Account thisAccount = accountDao.find(account);
        if (thisAccount.getBalance() - amount < 0) {
            throw new NotEnoughMoneyException();
        }
        thisAccount.setBalance(account.getBalance() - amount);
        accountDao.update(thisAccount);
    }

    @Override
    public double balance(Account account) throws UnknownAccountException, DaoException {
        return accountDao.find(account).getBalance();
    }

    @Override
    public void deposit(Account account, int amount) throws DaoException, IOException, DublicatePrimaryKeyException {
        Account thisAccount = accountDao.find(account);
        thisAccount.setBalance(thisAccount.getBalance() + amount);
        accountDao.update(thisAccount);
    }

    @Override
    public void transfer(Account from, Account to, int amount) throws NotEnoughMoneyException, UnknownAccountException, DaoException {
        Account fromAccount = accountDao.find(from);
        Account toAccount = accountDao.find(to);

        if (fromAccount.getBalance() - amount < 0){
            throw new NotEnoughMoneyException();
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

    }
}


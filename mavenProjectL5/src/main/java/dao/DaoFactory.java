package dao;

import domain.Account;

public interface DaoFactory<T> {

    Dao<Account> getDao(DaoType daoType);
}

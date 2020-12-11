package dao;

import Account;

public interface DaoFactory<T> {

    Dao<Account> getDao(DaoType daoType);
}

package impl;


import dao.Dao;
import dao.DaoDbConnectionSource;
import dao.DaoFactory;
import dao.DaoType;
import domain.Account;

public class AccountDaoFactory implements DaoFactory<Account> {


    @Override
    public Dao<Account> getDao(DaoType type) {
        Dao<Account> dao;
        switch (type) {
            case DATABASE:
                DaoDbConnectionSource service = new DaoDbConnectionSource();
                dao = new DbAccountDao(service);
                break;
            case JSON:
                dao = new JsonAccountDao();
                break;
            default:
                throw new UnsupportedOperationException("Don't find dao");
        }
        return dao;
    }
}

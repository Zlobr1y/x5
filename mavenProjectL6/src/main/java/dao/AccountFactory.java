package dao;


public interface AccountFactory<T> {

    Dao<T> getDao(DaoType daoType);
}

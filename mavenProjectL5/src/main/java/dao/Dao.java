package dao;

import dao.Exception.DaoException;

public interface Dao<T> {

    void insert(T item) throws DaoException;
    void delete(T item);
    T getById(int id);
}

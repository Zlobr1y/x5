package dao;

import exception.DaoException;

public interface Dao<T> {

    void insert(T item) throws DaoException;
    void update(T item) throws DaoException;
    void delete(T item) throws DaoException;
    T getById(int id) throws DaoException;
}

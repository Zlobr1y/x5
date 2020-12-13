package dao;

import exception.DaoException;
import exception.DublicatePrimaryKeyException;
import exception.UnknownAccountException;

import java.io.IOException;

public interface Dao<T> {

    void insert(T obj) throws DaoException, DublicatePrimaryKeyException;

    void update(T obj) throws DaoException, DublicatePrimaryKeyException, IOException;

    void delete(T obj) throws DaoException, UnknownAccountException;

    T getById(Long id);

    T find(T obj) throws DaoException;

}

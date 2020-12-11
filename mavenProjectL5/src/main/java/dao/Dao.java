package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import exception.DaoException;
import exception.DublicatePrimaryKeyException;
import exception.UnknownAccountException;

import java.io.IOException;

public interface Dao<T> {

    void insert(T obj) throws DaoException, DublicatePrimaryKeyException, JsonProcessingException;
    void update(T obj) throws DaoException, DublicatePrimaryKeyException, IOException;
    void delete(T obj) throws DaoException, UnknownAccountException;
    T getById(int id) throws DaoException, DublicatePrimaryKeyException;
    T find(T obj) throws DaoException;

}

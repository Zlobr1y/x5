package ru.titov.course.task7.dao;

import ru.titov.course.task7.exception.AccountException;
import ru.titov.course.task7.exception.DaoException;
import ru.titov.course.task7.exception.DublicatePrimaryKeyException;
import ru.titov.course.task7.exception.UnknownAccountException;

import java.io.IOException;

public interface Dao<T> {

    void insert(T obj) throws DaoException, DublicatePrimaryKeyException, AccountException;

    void update(T obj) throws DaoException, DublicatePrimaryKeyException, IOException, AccountException, UnknownAccountException;

    void delete(T obj) throws DaoException, UnknownAccountException, AccountException;

    T getById(int id) throws UnknownAccountException, DaoException;

    T find(T obj) throws DaoException;

}

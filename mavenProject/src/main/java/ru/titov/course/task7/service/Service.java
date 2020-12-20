package ru.titov.course.task7.service;

import ru.titov.course.task7.exception.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Service<T> {
    /**
     *
     * @param account account_id
     * @param amount amount to withdraw
     * @throws NotEnoughMoneyException
     * @throws UnknownAccountException
     * @throws DaoException
     * @throws IOException
     * @throws DublicatePrimaryKeyException
     */

    void withdraw(int id, int amount) throws NotEnoughMoneyException, UnknownAccountException, DaoException, IOException, DublicatePrimaryKeyException, AccountException;

    double balance(int id) throws UnknownAccountException, FileNotFoundException, DaoException;


    void deposit(T account, int amount) throws DaoException, IOException, DublicatePrimaryKeyException, AccountException, UnknownAccountException;

    void transfer(T from, T to, int amount) throws NotEnoughMoneyException, UnknownAccountException, DaoException;
}

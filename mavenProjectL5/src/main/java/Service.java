import exception.DaoException;
import exception.DublicatePrimaryKeyException;
import exception.NotEnoughMoneyException;
import exception.UnknownAccountException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Service<T> {
    void withdraw(T account, int amount) throws NotEnoughMoneyException, UnknownAccountException, DaoException, IOException, DublicatePrimaryKeyException;

    double balance(T account) throws UnknownAccountException, FileNotFoundException, DaoException;


    void deposit(T account, int amount) throws DaoException, IOException, DublicatePrimaryKeyException;

    void transfer(T from, T to, int amount) throws NotEnoughMoneyException, UnknownAccountException, DaoException;
}

package ru.titov.course.task7;

import ru.titov.course.task7.dao.Dao;
import ru.titov.course.task7.dao.AccountFactory;
import ru.titov.course.task7.dao.DaoType;
import ru.titov.course.task7.exception.DaoException;
import ru.titov.course.task7.exception.DublicatePrimaryKeyException;
import ru.titov.course.task7.service.AccountAccountFactory;

public class Main {
    public static void main(String[] args) throws DublicatePrimaryKeyException, DaoException {
        AccountFactory<Account> factory = new AccountAccountFactory();
        Dao<Account> dao = factory.getDao(DaoType.JSON);


    }
}

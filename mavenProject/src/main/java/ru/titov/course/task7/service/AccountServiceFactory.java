package ru.titov.course.task7.service;

import ru.titov.course.task7.Account;
import ru.titov.course.task7.dao.Dao;
import ru.titov.course.task7.dao.AccountFactory;
import ru.titov.course.task7.dao.DaoType;
import ru.titov.course.task7.dao.JsonAccountDao;
import ru.titov.course.task7.sourses.DaoJsonConnectionSource;

import java.io.File;

public class AccountServiceFactory implements AccountFactory<Account> {


    @Override
    public Dao<Account> getDao(DaoType type) {
        Dao<Account> dao;
        switch (type) {
            case JSON:
                dao = new JsonAccountDao(new DaoJsonConnectionSource(new File("json/")));
                break;
            case DATABASE:
            default:
                dao = new DbAccountDao();
        }
        return dao;
    }
}

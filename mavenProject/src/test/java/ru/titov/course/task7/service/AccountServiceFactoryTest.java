package ru.titov.course.task7.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.titov.course.task7.Account;
import ru.titov.course.task7.dao.AccountFactory;
import ru.titov.course.task7.dao.Dao;
import ru.titov.course.task7.dao.DaoType;

import static org.junit.Assert.assertEquals;

public class AccountServiceFactoryTest {
    AccountServiceFactory factory;

    @Before
    public void initializationAccountServiceFactory() {
        factory = new AccountServiceFactory();
    }

    @After
    public void destroyAccountServiceFactory() {
        factory = null;
    }

    @Test(expected = NullPointerException.class)
    public void testTypeNullJson() {
        Dao<Account> daoFactory = factory.getDao(DaoType.JSON);
        assertEquals(daoFactory, factory.getDao(null));
    }
    @Test(expected = NullPointerException.class)
    public void testTypeNullDb() {
        Dao<Account> daoFactory = factory.getDao(DaoType.DATABASE);
        assertEquals(daoFactory, factory.getDao(null));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTypeAbrakadabraJson(){
        Dao<Account> daoFactory = factory.getDao(DaoType.JSON);
        assertEquals(daoFactory, factory.getDao(DaoType.valueOf("abrakadabra")));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTypeAbrakadabraDb(){
        Dao<Account> daoFactory = factory.getDao(DaoType.DATABASE);
        assertEquals(daoFactory, factory.getDao(DaoType.valueOf("abrakadabra")));
    }
}

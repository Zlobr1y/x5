package ru.titov.course.task7.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.titov.course.task7.Account;
import ru.titov.course.task7.Holder;
import ru.titov.course.task7.dao.Dao;
import ru.titov.course.task7.dao.JsonAccountDao;
import ru.titov.course.task7.exception.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AccountServiceTest {
    private Dao<Account> dao;
    private AccountService service;

    @Before
    public void initializationAccountService() {
        dao = Mockito.mock(JsonAccountDao.class);
        service = new AccountService(dao);
    }

    @After
    public void destroyAccountService() {
        service = null;
    }

    @Test(expected = UnknownAccountException.class)
    public void testWithdrawUnknownAccount() throws DaoException, UnknownAccountException, AccountException, NotEnoughMoneyException, DublicatePrimaryKeyException, IOException {
        Mockito.doThrow(UnknownAccountException.class).when(dao).getById(0);
        service.withdraw(0, 200);
    }
    @Test(expected = NotEnoughMoneyException.class)
    public void testWithdrawNoMoney() throws DaoException, UnknownAccountException, AccountException, NotEnoughMoneyException, DublicatePrimaryKeyException, IOException {
        Mockito.when(dao.getById(0)).thenReturn(new Account(0,200.12,new Holder("Titov")));
        service.withdraw(0, 500);
    }
    @Test
    public void testWithdraw() throws DaoException, UnknownAccountException, AccountException, NotEnoughMoneyException, DublicatePrimaryKeyException, IOException {
        Mockito.when(dao.getById(0)).thenReturn(new Account(0,200.12,new Holder("Titov")));
        service.withdraw(0,50);
    }
    @Test(expected = UnknownAccountException.class)
    public void testBalanceUnknown() throws DaoException, UnknownAccountException {
        Mockito.doThrow(UnknownAccountException.class).when(dao).getById(0);
        service.balance(0);
    }
    @Test
    public void testBalance() throws DaoException, UnknownAccountException {
        Mockito.when(dao.getById(0)).thenReturn(new Account(0,200.12,new Holder("Titov")));
        assertEquals(100, 200.12);
    }


}

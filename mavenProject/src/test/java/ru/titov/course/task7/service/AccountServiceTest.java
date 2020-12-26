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

import static org.junit.Assert.*;

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
    public void testBalanceUnknownAccount() throws DaoException, UnknownAccountException {
        Mockito.doThrow(UnknownAccountException.class).when(dao).getById(0);
        service.balance(0);
    }
    @Test
    public void testBalance() throws DaoException, UnknownAccountException {
        Mockito.when(dao.getById(0)).thenReturn(new Account(0,200,new Holder("Titov")));
        int testId = (int) service.balance(0);
        assertEquals(testId, 200);
    }
    @Test(expected = UnknownAccountException.class)
    public void testDepositUnknownAccount() throws DaoException, UnknownAccountException, DublicatePrimaryKeyException, AccountException, IOException {
        Mockito.doThrow(UnknownAccountException.class).when(dao).getById(0);
        service.deposit(0, 500);
    }
    @Test
    public void testDeposit() throws DaoException, UnknownAccountException, DublicatePrimaryKeyException, AccountException, IOException {
        Mockito.when(dao.getById(0)).thenReturn(new Account(0,200,new Holder("Titov")));
        service.deposit(0,500);
    }
    @Test(expected = UnknownAccountException.class)
    public void testTransferUnknownAccount() throws DaoException, UnknownAccountException, NotEnoughMoneyException, DublicatePrimaryKeyException, AccountException, IOException {
        Mockito.doThrow(UnknownAccountException.class).when(dao).getById(0);
        Mockito.doThrow(UnknownAccountException.class).when(dao).getById(1);
        service.transfer(0, 1, 500);
    }
    @Test(expected = UnknownAccountException.class)
    public void testTransferUnknownAccountFirst() throws DaoException, UnknownAccountException, NotEnoughMoneyException, DublicatePrimaryKeyException, AccountException, IOException {
        Mockito.when(dao.getById(0)).thenReturn(new Account(0,200,new Holder("Titov")));
        Mockito.doThrow(UnknownAccountException.class).when(dao).getById(1);
        service.transfer(0, 1, 500);
    }
    @Test(expected = UnknownAccountException.class)
    public void testTransferUnknownAccountSecond() throws DaoException, UnknownAccountException, NotEnoughMoneyException, DublicatePrimaryKeyException, AccountException, IOException {
        Mockito.doThrow(UnknownAccountException.class).when(dao).getById(0);
        Mockito.when(dao.getById(1)).thenReturn(new Account(1,500,new Holder("Zharkov")));
        service.transfer(0, 1, 500);
    }
    @Test(expected = NotEnoughMoneyException.class)
    public void testTransferNoMoney() throws DaoException, UnknownAccountException, NotEnoughMoneyException, DublicatePrimaryKeyException, AccountException, IOException {
        Mockito.when(dao.getById(0)).thenReturn(new Account(0,200,new Holder("Titov")));
        Mockito.when(dao.getById(1)).thenReturn(new Account(1,500,new Holder("Zharkov")));
        service.transfer(0, 1, 500);

    }
    @Test
    public void testTransfer() throws DaoException, UnknownAccountException, NotEnoughMoneyException, DublicatePrimaryKeyException, AccountException, IOException {
        Mockito.when(dao.getById(0)).thenReturn(new Account(0,200,new Holder("Titov")));
        Mockito.when(dao.getById(1)).thenReturn(new Account(1,500,new Holder("Zharkov")));
        service.transfer(0, 1, 50);
    }



}

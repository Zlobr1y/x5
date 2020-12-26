package ru.titov.course.task7.dao;


import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.titov.course.task7.Account;
import ru.titov.course.task7.Holder;
import ru.titov.course.task7.exception.AccountException;
import ru.titov.course.task7.exception.DaoException;
import ru.titov.course.task7.exception.DublicatePrimaryKeyException;
import ru.titov.course.task7.exception.UnknownAccountException;
import ru.titov.course.task7.sourses.DaoJsonConnectionSource;


import java.io.IOException;

public class JsonAccountDaoTest {
    private JsonAccountDao jsonAccountDao;
    final Gson gson = new Gson();
    DaoJsonConnectionSource source;

    @Before
    public void initializationJsonAccountDao() {
        source = Mockito.mock(DaoJsonConnectionSource.class);
        jsonAccountDao = new JsonAccountDao(source);

    }

    @After
    public void destroyObjJsonAccountDao() {
        jsonAccountDao = null;
    }

    @Test(expected = AccountException.class)
    public void testInsertNull() throws AccountException, DaoException, DublicatePrimaryKeyException {
        jsonAccountDao.insert(null);
    }

    @Test(expected = DublicatePrimaryKeyException.class)
    public void testInsertDublicate() throws DaoException, AccountException, DublicatePrimaryKeyException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
        Account titov = new Account(0, 100, new Holder("Titov"));
        jsonAccountDao.insert(titov);
    }
    @Test
    public void testInsert() throws DublicatePrimaryKeyException, DaoException, AccountException {
        jsonAccountDao.insert(new Account(0, 100, new Holder("Titov")));
    }

    @Test(expected = AccountException.class)
    public void testUpdateNullAccount() throws AccountException, DaoException, UnknownAccountException {
        jsonAccountDao.update(null);
    }

    @Test(expected = AccountException.class)
    public void testUpdateNoAccount() throws AccountException, DaoException, UnknownAccountException {
        Mockito.when(source.accountExists(0)).thenReturn(false);
        jsonAccountDao.update(new Account(0, 123.12, new Holder("Igrokov")));
    }

    @Test(expected = DaoException.class)
    public void testUpdateWriteError() throws IOException, AccountException, DaoException, UnknownAccountException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
        Mockito.doThrow(IOException.class).when(source).read(0);
        jsonAccountDao.update(new Account(0, 256.16, new Holder("Lavrov")));
    }

    @Test
    public void testUpdate() throws IOException, AccountException, DaoException, UnknownAccountException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
//        Mockito.doReturn(true).when(source.accountExists(0));
        Mockito.when(source.read(0)).thenReturn(gson.toJson(new Account(0, 512.32, new Holder("Kromovsky"))));
        jsonAccountDao.update(new Account(0, 1024.64, new Holder("Kromovsky")));
    }

    @Test(expected = AccountException.class)
    public void testDeleteNull() throws DaoException, UnknownAccountException, AccountException, IOException {
        jsonAccountDao.delete(null);
    }

    @Test(expected = UnknownAccountException.class)
    public void testDeleteAccountless() throws DaoException, UnknownAccountException, AccountException, IOException {
        Mockito.when(source.accountExists(0)).thenReturn(false);
        jsonAccountDao.delete(new Account(0, 1024.12, new Holder("Paromov")));
    }

    @Test(expected = DaoException.class)
    public void testDeleteDao() throws IOException, DaoException, UnknownAccountException, AccountException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
        Mockito.doThrow(IOException.class).when(source).delete(0);
        jsonAccountDao.delete(new Account(0, 100, new Holder("Titov")));
    }

    @Test
    public void testDelete() throws DaoException, UnknownAccountException, AccountException, IOException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
        jsonAccountDao.delete(new Account(0, 2345.67, new Holder("Onishenko")));
    }

    @Test(expected = UnknownAccountException.class)
    public void testGetFileUnknownAccount() throws DaoException, UnknownAccountException {
        Mockito.when(source.accountExists(0)).thenReturn(false);
        jsonAccountDao.getById(0);
    }

    @Test(expected = DaoException.class)
    public void testGetDao() throws DaoException, UnknownAccountException, IOException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
        Mockito.doThrow(IOException.class).when(source).read(0);
        jsonAccountDao.getById(0);
    }

    @Test
    public void testGetById() throws IOException, DaoException, UnknownAccountException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
//        Account titov = new Account(0, 123, new Holder("titov"));
        Mockito.when(source.read(0)).thenReturn(gson.toJson(new Account(0, 123, new Holder("titov"))));
        Assert.assertEquals(new Account(0, 123, new Holder("titov")), jsonAccountDao.getById(0));
    }



}

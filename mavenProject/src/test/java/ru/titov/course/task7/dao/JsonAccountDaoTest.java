package ru.titov.course.task7.dao;


import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.titov.course.task7.Account;
import ru.titov.course.task7.Holder;
import ru.titov.course.task7.exception.AccountException;
import ru.titov.course.task7.exception.DaoException;
import ru.titov.course.task7.exception.DublicatePrimaryKeyException;
import ru.titov.course.task7.sourses.DaoJsonConnectionSource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonAccountDaoTest {
    private JsonAccountDao jsonAccountDao;
    final Gson gson = new Gson();
    DaoJsonConnectionSource source;
    FileWriter writer;

    @Before
    public void initializationJsonAccountDao(){
        jsonAccountDao = new JsonAccountDao();
        source = Mockito.mock(DaoJsonConnectionSource.class);
        writer = Mockito.mock(FileWriter.class);
    }
    @After
    public void destroyObjJsonAccountDao(){
        jsonAccountDao = null;
    }

    @Test(expected = AccountException.class)
    public void testInsertNull() throws AccountException, DaoException, DublicatePrimaryKeyException {
        jsonAccountDao.insert(null);
    }

    @Test(expected = DublicatePrimaryKeyException.class)
    public void testInsertDublicate() throws DaoException, AccountException, DublicatePrimaryKeyException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
        jsonAccountDao.insert(new Account(0, 100.00, new Holder("Titov")));
    }

    @Test(expected = AccountException.class)
    public void testUpdateNullAccount() throws AccountException, DaoException {
        jsonAccountDao.update(null);
    }

    @Test(expected = AccountException.class)
    public void testUpdateNoAccount() throws AccountException, DaoException {
        Mockito.when(source.accountExists(0)).thenReturn(false);
        jsonAccountDao.update(new Account(0, 123.12, new Holder("Igrokov")));
    }
    @Test(expected = DaoException.class)
    public void testUpdateWriteError() throws IOException, AccountException, DaoException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
        Mockito.doThrow(IOException.class).when(source).read(0);
        jsonAccountDao.update(new Account(0, 256.16, new Holder("Lavrov")));
    }
    @Test
    public void testUpdate() throws IOException, AccountException, DaoException {
        Mockito.when(source.accountExists(0)).thenReturn(true);
        Mockito.when(source.read(0)).thenReturn(String.valueOf(new Account(0, 512.32,new Holder("Kromovsky"))));
        jsonAccountDao.update(new Account(0, 1024.64,new Holder("Kromovsky")));
    }

}

package ru.titov.course.task7.source;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.titov.course.task7.dao.JsonAccountDao;
import ru.titov.course.task7.sourses.DaoJsonConnectionSource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DaoJsonConnectionSourceTest {
    File directory;
    DaoJsonConnectionSource source;

    @Before
    public void initializationDaoJsonConnectionSource() {
        directory = Mockito.mock(File.class);
        source = new DaoJsonConnectionSource(directory);
    }

    @After
    public void destroyObjJsonAccountDao() {
        source = null;
    }

    @Test(expected = IOException.class)
    public void testWrite() throws IOException {
        source.write(0, "Titov");
    }

    @Test(expected = IOException.class)
    public void testDel() throws IOException {
        source.delete(0);
    }
    @Test(expected = IOException.class)
    public void testRead() throws IOException {
        source.read(0);
    }


}

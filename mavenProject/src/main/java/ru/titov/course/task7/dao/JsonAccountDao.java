package ru.titov.course.task7.dao;

import com.google.gson.Gson;
import ru.titov.course.task7.exception.AccountException;
import ru.titov.course.task7.exception.DaoException;
import ru.titov.course.task7.exception.DublicatePrimaryKeyException;
import ru.titov.course.task7.exception.UnknownAccountException;
import ru.titov.course.task7.Account;
import ru.titov.course.task7.sourses.DaoJsonConnectionSource;

import java.io.File;
import java.io.IOException;

public class JsonAccountDao implements Dao<Account> {
    private DaoJsonConnectionSource daoJsonConnectionSource;
    private final Gson gson = new Gson();

    public JsonAccountDao() {
        this.daoJsonConnectionSource = new DaoJsonConnectionSource(new File("json/"));
    }


    @Override
    public void insert(Account obj) throws AccountException, DublicatePrimaryKeyException, DaoException {
        if (obj == null) {
            throw new AccountException("Account is null, something went wrong.");
        }
        if (daoJsonConnectionSource.accountExists(obj.getId())) {
            throw new DublicatePrimaryKeyException("Account already exists");
        }
        try {
            daoJsonConnectionSource.write(obj.getId(), gson.toJson(obj));
        } catch (IOException e) {
            throw new DaoException("Can't write to file");
        }
    }


    @Override
    public void update(Account obj) throws DaoException, AccountException, UnknownAccountException {
        if (obj == null) {
            throw new AccountException("Account is null, something went wrong.");
        }
        if (!daoJsonConnectionSource.accountExists(obj.getId())) {
            throw new AccountException("Account doesn't exist");
        }
        Account inDataBase = getById(obj.getId());
        inDataBase.setBalance((obj.getBalance()));
        try {
            daoJsonConnectionSource.write(obj.getId(), gson.toJson(inDataBase));
        } catch (IOException e) {
            throw new DaoException("File write error");
        }
        try {
            daoJsonConnectionSource.write(obj.getId(), gson.toJson(inDataBase));
        } catch (IOException ex) {
            throw new DaoException("Cant write to file");
        }


    }

    @Override
    public void delete(Account obj) throws UnknownAccountException, AccountException {
        if (obj == null){
            throw new AccountException("Account is null, something went wrong.");
        }
        File inDataBase = new File(daoJsonConnectionSource.getSource().getPath() + File.separator + obj.getId() + ".json");
        if (!daoJsonConnectionSource.accountExists(obj.getId())) {
            throw new UnknownAccountException("404. File is not found");
        }
        try {
            daoJsonConnectionSource.delete(obj.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Account getById(int id) throws UnknownAccountException, DaoException {
        Account account = null;
        if (!daoJsonConnectionSource.accountExists(id)){
            throw new UnknownAccountException("404. File is not found");
        }
        try {
            account = gson.fromJson(daoJsonConnectionSource.read(id), Account.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DaoException("Can't read file");
        }
        if (account == null){
            throw new DaoException("Reading error");
        }
        return account;
    }

    @Override
    public Account find(Account obj) throws DaoException {
        return null;
    }
}

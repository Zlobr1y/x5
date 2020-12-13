
import com.google.gson.Gson;
import dao.Dao;
import exception.DaoException;
import exception.DublicatePrimaryKeyException;
import exception.UnknownAccountException;
import jpa.Account;
import sourses.DaoJsonConnectionSource;

import java.io.File;
import java.io.IOException;

public class JsonAccountDao implements Dao<Account> {
    private DaoJsonConnectionSource daoJsonConnectionSource;
        private final Gson gson = new Gson();

    public JsonAccountDao() {
        this.daoJsonConnectionSource = new DaoJsonConnectionSource("json/");
    }


    @Override
    public void insert(Account obj) throws DaoException, DublicatePrimaryKeyException {
        File newAccount = new File(daoJsonConnectionSource.getDirectorySource().getPath() + File.separator + obj.getId() + ".json");
        if (newAccount.exists()){
            throw new DublicatePrimaryKeyException();
        }
        try {
            daoJsonConnectionSource.write(new File("json/"), gson.toJson(obj));
        } catch (IOException e) {
            throw new DaoException("Can't write to file", e);
        }

    }
    

    @Override
    public void update(Account obj) throws DaoException, DublicatePrimaryKeyException, IOException {
        Account inDataBase = getById((long) obj.getId());
        inDataBase.setBalance((obj.getBalance()));
        File newAccount = new File(daoJsonConnectionSource.getDirectorySource().getPath()+File.separator+obj.getId()+".json");
        try {
            daoJsonConnectionSource.write(newAccount, gson.toJson(obj));
        } catch (IOException e) {
            throw new DaoException("Проблема записи в файл", e);
        }


    }

    @Override
    public void delete(Account obj) throws DaoException, UnknownAccountException {
        File inDataBase = new File(daoJsonConnectionSource.getDirectorySource().getPath()+File.separator+obj.getId()+".json");
        if (!inDataBase.exists()){
            throw new UnknownAccountException("Файл не найден");
        }
        try {
            daoJsonConnectionSource.delete(inDataBase);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Account getById(Long id)  {
        Account account = null;
        File newAccount = new File(daoJsonConnectionSource.getDirectorySource().getPath() + File.separator + id + ".json");
        try {
            account = gson.fromJson(daoJsonConnectionSource.read(newAccount), Account.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Проблемы с читаемым файлом");
        }
        if (!newAccount.exists());
        return account;
    }

    @Override
    public Account find(Account obj) throws DaoException {
        return null;
    }
}

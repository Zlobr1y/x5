import com.fasterxml.jackson.core.JsonProcessingException;
import dao.Dao;
import dao.DaoType;
import exception.DaoException;
import exception.DublicatePrimaryKeyException;
import exception.UnknownAccountException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AccountDaoFactory accountDaoFactory = new AccountDaoFactory();
        Dao<Account> dao = accountDaoFactory.getDao(DaoType.DATABASE);

        Account account = new Account();
        account.setId(1);
        account.setBalance(12.1);

        try {
            try {
                dao.insert(account);
            } catch (DublicatePrimaryKeyException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println(dao.getById(1));
            account.setBalance(20);
            dao.update(account);
            System.out.println(dao.getById(1));
            dao.delete(account);
            System.out.println(dao.getById(1));
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (UnknownAccountException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DublicatePrimaryKeyException e) {
            e.printStackTrace();
        }

        Service<Account> accountDbService = new AccountService(DaoType.DATABASE);
        try {
            accountDbService.balance(account);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        Service<Account> accountJsonService = new AccountService(DaoType.JSON);
        try {
            accountJsonService.balance(account);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}

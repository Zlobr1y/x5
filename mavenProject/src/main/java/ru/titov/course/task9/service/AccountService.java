package ru.titov.course.task9.service;

import com.google.gson.Gson;
import ru.titov.course.task9.Account;
import ru.titov.course.task9.exception.*;

import java.io.IOException;

public class AccountService {
//    private final Dao<Account> accountDao;

    private final Gson gson = new Gson();
    private FileRepository fileRepository;

    public AccountService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void withdraw(int id, int amount) throws NotEnoughMoneyException, DaoException, IOException, DublicatePrimaryKeyException, AccountException, UnknownAccountException {
        Account thisAccount = getById(id);
        if (thisAccount.getBalance() - amount < 0) {
            throw new NotEnoughMoneyException("Account " + thisAccount.getHolder().getName() + " need more gold.");
        }
        thisAccount.setBalance(thisAccount.getBalance() - amount);
        fileRepository.write(id, gson.toJson(thisAccount, Account.class));
    }

    public double balance(int id) throws UnknownAccountException, DaoException {
        return getById(id).getBalance();
    }

    public void deposit(int id, int amount) throws DaoException, IOException, DublicatePrimaryKeyException, AccountException, UnknownAccountException {
        Account thisAccount = getById(id);
        thisAccount.setBalance(thisAccount.getBalance() + amount);
        fileRepository.write(id, gson.toJson(thisAccount, Account.class));
    }

    public void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException, DaoException, IOException, DublicatePrimaryKeyException, AccountException {
        Account fromAccount = getById(from);
        Account toAccount = getById(to);

        if (fromAccount.getBalance() - amount <= 0) {
            throw new NotEnoughMoneyException("Account " + fromAccount.getHolder().getName() + " need more gold.");
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        update(fromAccount);
        update(toAccount);

    }

    public void insert(Account obj) throws AccountException, DublicatePrimaryKeyException, DaoException {
        if (obj == null) {
            throw new AccountException("Account is null, something went wrong.");
        }
        if (fileRepository.accountExists(obj.getId())) {
            throw new DublicatePrimaryKeyException("Account already exists");
        }
        try {
            fileRepository.write(obj.getId(), gson.toJson(obj));
        } catch (IOException e) {
            throw new DaoException("Can't write to file");
        }
    }


    public void update(Account obj) throws DaoException, AccountException, UnknownAccountException {
        if (obj == null) {
            throw new AccountException("Account is null, something went wrong.");
        }
        if (!fileRepository.accountExists(obj.getId())) {
            throw new AccountException("Account doesn't exist");
        }
        Account inDataBase = getById(obj.getId());
        inDataBase.setBalance((obj.getBalance()));
        try {
            fileRepository.write(obj.getId(), gson.toJson(inDataBase));
        } catch (IOException e) {
            throw new DaoException("File write error");
        }
        try {
            fileRepository.write(obj.getId(), gson.toJson(inDataBase));
        } catch (IOException ex) {
            throw new DaoException("Cant write to file");
        }


    }

    public void delete(Account obj) throws UnknownAccountException, AccountException, DaoException, IOException {
        if (obj == null) {
            throw new AccountException("Account is null, something went wrong.");
        }
//        File inDataBase = new File(daoJsonConnectionSource.getSource().getPath() + File.separator + obj.getId() + ".json");
        if (!fileRepository.accountExists(obj.getId())) {
            throw new UnknownAccountException("404. File is not found");
        }
        try {
            fileRepository.delete(obj.getId());
        } catch (IOException e) {
            throw new DaoException("Какая-то чепушня c файлом");
        }

    }


    public Account getById(int id) throws UnknownAccountException, DaoException {
        Account account = null;
        if (!fileRepository.accountExists(id)) {
            throw new UnknownAccountException("404. File is not found");
        }
        try {
            account = gson.fromJson(fileRepository.read(id), Account.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DaoException("Can't read file");
        }
        if (account == null) {
            throw new DaoException("Reading error");
        }
        return account;
    }

    public Account find(Account obj) throws DaoException {
        return null;
    }
}


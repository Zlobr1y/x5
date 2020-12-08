import dao.Dao;
import dao.DaoType;
import impl.AccountDaoFactory;
import domain.Account;
import exception.DaoException;

public class Main {
    public static void main(String[] args) {
        AccountDaoFactory accountDaoFactory = new AccountDaoFactory();
        Dao<Account> dao = accountDaoFactory.getDao(DaoType.DATABASE);


        Account account = new Account();
        account.setId(1);
        account.setBalance(12.1);



        try {
            dao.insert(account);
            System.out.println(dao.getById(1));
            account.setBalance(20);
            dao.update(account);
            System.out.println(dao.getById(1));
            dao.delete(account);
            System.out.println(dao.getById(1));
        } catch (DaoException e){
            e.printStackTrace();
        }
    }
}

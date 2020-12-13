import dao.Dao;
import dao.AccountFactory;
import dao.DaoType;
import exception.DaoException;
import exception.DublicatePrimaryKeyException;
import jpa.Account;

public class Main {
    public static void main(String[] args) throws DublicatePrimaryKeyException, DaoException {
        AccountFactory<Account> factory = new AccountAccountFactory();
        Dao<Account> dao = factory.getDao(DaoType.DATABASE);
        Account account1 = new Account(12500.12);
        try {
            dao.insert(account1);
            dao.insert(new Account(12345.12));
            dao.insert(new Account(56789.54));
            System.out.println(account1.getBalance());

        } catch (DaoException e) {
            e.printStackTrace();
        } catch (DublicatePrimaryKeyException e) {
            e.printStackTrace();
        }



    }
}

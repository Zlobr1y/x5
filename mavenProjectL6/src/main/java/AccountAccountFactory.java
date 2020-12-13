import dao.Dao;
import jpa.Account;
import dao.AccountFactory;
import dao.DaoType;

public class AccountAccountFactory implements AccountFactory<Account> {


    @Override
    public Dao<Account> getDao(DaoType type) {
        Dao<Account> dao;
        switch (type) {
            case JSON:
                dao = new JsonAccountDao();
                break;
            case DATABASE:
            default:
                dao = new DbAccountDao();
        }
        return dao;
    }
}

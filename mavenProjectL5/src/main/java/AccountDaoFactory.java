import dao.Dao;
import sourses.DaoDbConnectionSource;
import dao.DaoFactory;
import dao.DaoType;
import sourses.DaoJsonConnectionSource;

public class AccountDaoFactory implements DaoFactory<Account> {


    @Override
    public Dao<Account> getDao(DaoType type) {
        Dao<Account> dao;
        switch (type) {
            case DATABASE:
                dao = new DbAccountDao(new DaoDbConnectionSource());
                break;
            case JSON:
                dao = new JsonAccountDao();
                break;
            default:
                throw new UnsupportedOperationException("Don't find dao");
        }
        return dao;
    }
}

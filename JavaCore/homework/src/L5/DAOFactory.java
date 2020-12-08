package L5;

public interface DAOFactory<T> {
    DAO<T> getDao(String type);
}

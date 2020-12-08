package L5.dao;

public interface DAOFactory<T> {

    DAO<T> getDAO(DAOType type);
}

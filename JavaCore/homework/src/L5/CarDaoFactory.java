package L5;

import L5.dao.DAO;

public class CarDaoFactory implements DAOFactory<Car> {
    @Override
    public DAO<Car> getDao(String type) {
        DAO<Car> dao = null;
        switch (type) {
            case "db":
                dao = new DbCarDao();
                break;
            case "json":
                dao = new JsonCarDao();
                break;
            default:
                throw new UnsupportedOperationException("Don't find dao");
        }
        return dao;
    }
}

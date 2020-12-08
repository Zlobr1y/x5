package dao.impl;


import dao.Dao;
import dao.DaoFactory;
import dao.DaoType;
import dao.impl.DbCarDao;
import dao.impl.JsonCarDao;
import domain.Car;

public class CarDaoFactory implements DaoFactory<Car> {


    @Override
    public Dao<Car> getDao(DaoType type) {
        Dao<Car> dao;
        switch (type) {
            case DATABASE:
                dao = new DbCarDao();
                break;
            case JSON:
                dao = new JsonCarDao();
                break;
            default:
                throw new UnsupportedOperationException("Don't find dao");
        }
        return dao;
    }
}

package dao.impl;


import dao.Dao;
import dao.DaoDbConnectionSource;
import dao.DaoFactory;
import dao.DaoType;
import domain.Car;

public class CarDaoFactory implements DaoFactory<Car> {


    @Override
    public Dao<Car> getDao(DaoType type) {
        Dao<Car> dao;
        switch (type) {
            case DATABASE:
                DaoDbConnectionSource service = new DaoDbConnectionSource();
                dao = new DbCarDao(service);
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

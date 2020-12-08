package dao;

import domain.Car;

public interface DaoFactory<T> {

    Dao<Car> getDao(DaoType daoType);
}

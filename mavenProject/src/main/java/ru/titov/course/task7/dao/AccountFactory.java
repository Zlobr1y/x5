package ru.titov.course.task7.dao;


public interface AccountFactory<T> {

    Dao<T> getDao(DaoType daoType);
}

package ru.titov.course.task7.sourses;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoDbConnectionSource {
    private final EntityManagerFactory entityManagerFactory;

    public DaoDbConnectionSource() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}

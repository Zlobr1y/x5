package sourses;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoDbConnectionSource {
    private final EntityManagerFactory entityManagerFactory;

    public DaoDbConnectionSource() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}

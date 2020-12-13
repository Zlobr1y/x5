import exception.DublicatePrimaryKeyException;
import jpa.Account;
import sourses.DaoDbConnectionSource;
import exception.DaoException;
import dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAccountDao implements Dao<Account> {
    private DaoDbConnectionSource service = new DaoDbConnectionSource();


    @Override
    public void insert(Account obj) throws DaoException {

        EntityManager entityManager = service.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(obj);
//            entityManager.refresh(account);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("error insert", e);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public void update(Account obj) throws DaoException {
        EntityManager entityManager = service.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Account account = entityManager.find(Account.class, obj.getId());
            account.setBalance(obj.getBalance());
            entityManager.refresh(account);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new DaoException("error update", e);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public void delete(Account obj) throws DaoException {
        EntityManager entityManager = service.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Account account = entityManager.find(Account.class, obj.getId());
            entityManager.remove(account);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("delete error", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Account getById(Long id) {
        EntityManager entityManager = service.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Account account = null;
        try {
            Query query = entityManager.createQuery("Select c from Account c where c.id=:id");
            query.setParameter("id", id);
            account = (Account) query.getSingleResult();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return account;
    }


    @Override
    public Account find(Account obj) throws DaoException {
        EntityManager entityManager = service.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Account account = null;
        try {
            account = entityManager.find(Account.class, obj.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("фигня какая-то", e);
        } finally {
            entityManager.close();
        }
        return account;
    }
}
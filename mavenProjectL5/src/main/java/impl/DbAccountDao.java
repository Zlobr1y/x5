package impl;

import dao.DaoDbConnectionSource;
import exception.DaoException;
import domain.Account;
import dao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAccountDao implements Dao<Account> {
    private final DaoDbConnectionSource service;

    private final String ID = "id";
    private final String BALANCE = "balance";

    private final static String REGISTER_QUERY = "INSERT INTO ACCOUNT (id, balance) VALUES(?,?);";
    private final static String DELETE_QUERY = "DELETE FROM ACCOUNT WHERE id=?;";
    private final static String UPDATE_QUERY = "UPDATE ACCOUNT SET balance=? WHERE id=?";
    private final static String GET_QUERY = "SELECT * FROM ACCOUNT WHERE id=?;";

    public DbAccountDao(DaoDbConnectionSource service) {
        this.service = service;
    }

    @Override
    public void insert(Account item) throws DaoException {
        try (Connection connection = service.getConnection();
             PreparedStatement statement = connection.prepareStatement(REGISTER_QUERY)) {

            statement.setInt(1, item.getId(ID));
            statement.setDouble(2, item.getBalance(BALANCE));

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("error insert", e);
        }
    }

    @Override
    public void update(Account item) throws DaoException {
        try (Connection connection = service.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setInt(2, item.getId(ID));
            statement.setDouble(1, item.getBalance(BALANCE));

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("error update", e);
        }

    }

    @Override
    public void delete(Account item) throws DaoException {
        try (Connection connection = service.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {

            statement.setInt(1, item.getId(ID));

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("delete error", e);
        }

    }

    @Override
    public Account getById(int id) {
        Account account = new Account();
        try (Connection connection = service.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_QUERY)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (!set.next()) {
                throw new RuntimeException("No such user.");
            }
            return new Account(set.getInt(ID), set.getDouble(BALANCE));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
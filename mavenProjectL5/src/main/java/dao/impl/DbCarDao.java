package dao.impl;

import dao.DaoDbConnectionService;
import dao.Exception.DaoException;
import domain.Car;
import dao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbCarDao implements Dao<Car> {

    private final static String REGISTER_QUERY = "INSERT INTO CAR (vin, color, model, price) VALUES(?,?,?,?);";
    private final static String DEREGISTER_QUERY = "DELETE FROM CAR WHERE vin=?;";
    private final static String GET_QUERY = "SELECT * FROM CAR WHERE vin=?;";

    @Override
    public void insert(Car item) throws DaoException {
        try {
            Connection connection = DaoDbConnectionService.getConnection();

            PreparedStatement statement = connection.prepareStatement(REGISTER_QUERY);

            statement.setString(1, item.getVin());
            statement.setString(2, item.getColor());
            statement.setString(3, item.getModel());
            statement.setDouble(4, item.getPrice());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("error insert", e);
        }
    }

    @Override
    public void delete(Car item) {

    }

    @Override
    public Car getById(int id) {
        return null;
    }
}
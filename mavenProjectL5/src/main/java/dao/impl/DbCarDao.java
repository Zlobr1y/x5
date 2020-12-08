package dao.impl;

import dao.DaoDbConnectionSource;
import dao.Exception.DaoException;
import domain.Car;
import dao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbCarDao implements Dao<Car> {
    private final DaoDbConnectionSource service;

    private final String VIN = "vin";
    private final String MODEL = "model";
    private final static String REGISTER_QUERY = "INSERT INTO CAR (vin, color, model, price) VALUES(?,?,?,?);";
    private final static String DEREGISTER_QUERY = "DELETE FROM CAR WHERE vin=?;";
    private final static String GET_QUERY = "SELECT * FROM CAR WHERE vin=?;";

    public DbCarDao(DaoDbConnectionSource service) {
        this.service = service;
    }

    @Override
    public void insert(Car item) throws DaoException {
        try(Connection connection = service.getConnection();
            PreparedStatement statement = connection.prepareStatement(REGISTER_QUERY)) {




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
        Car car = new Car();
        try (Connection connection = service.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_QUERY)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();
            if (!set.next()) {
                throw new RuntimeException("No such user.");
            }
            car.setVin(set.getString(VIN));
            car.setModel(set.getString(MODEL));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return car;
    }
}
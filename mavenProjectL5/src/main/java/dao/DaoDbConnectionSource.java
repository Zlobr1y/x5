package dao;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoDbConnectionSource {
    private String urlHostName;
    private String userName;
    private String userPass;


    private final BasicDataSource dataSource = new BasicDataSource();

    public DaoDbConnectionSource(){
        /*urlHostName = "jdbc:postgresql://localhost:5432/postgres";
        userName = "postgres";
        userPass = "qwerty$4";*/

        dataSource.setUrl("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM './schema.sql'\\;RUNSCRIPT FROM './data.sql'");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setMaxIdle(10);
        dataSource.setMinIdle(5);
        dataSource.setMaxOpenPreparedStatements(20);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}

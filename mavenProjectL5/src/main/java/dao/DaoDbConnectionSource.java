package dao;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoDbConnectionSource {


    private final BasicDataSource dataSource = new BasicDataSource();

    public DaoDbConnectionSource() {


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

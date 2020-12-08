package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoDbConnectionService<T> {
    private static String urlHostName;
    private static String userName;
    private static String userPass;
    private static DaoDbConnectionService dataSource = new DaoDbConnectionService();

    public DaoDbConnectionService(){
        urlHostName = "jdbc:postgresql://localhost:5432/postgres";
        userName = "postgres";
        userPass = "qwerty$4";
    }

    public static Connection getConnection() throws SQLException {
        Connection dbConnection = DriverManager.getConnection(urlHostName, userName, userPass);
        return dbConnection;
    }

    public static String getUrlHostName() {
        return urlHostName;
    }

    public static void setUrlHostName(String urlHostName) {
        DaoDbConnectionService.urlHostName = urlHostName;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        DaoDbConnectionService.userName = userName;
    }

    public static String getUserPass() {
        return userPass;
    }

    public static void setUserPass(String userPass) {
        DaoDbConnectionService.userPass = userPass;
    }
}

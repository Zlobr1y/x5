import java.sql.*;

public class DbConnectController {

    protected String urlHostname;
    protected String userName;
    protected String userPass;
    protected String createTableSQL;
    protected String balanceSelect;
    protected String balanceUpdate;
    protected String accountInsert;

    public DbConnectController() {
        urlHostname = "jdbc:postgresql://localhost/postgres";
        userName = "postgres";
        userPass = "qwerty$4";
        createTableSQL = "CREATE TABLE IF NOT EXISTS public.\"AccountsTest\" " +
                "(\"accountId\" integer NOT NULL, " +
                "amount double precision, " +
                "PRIMARY KEY (\"accountId\"));";
        balanceSelect = "SELECT \"accountId\", amount FROM public.\"AccountsTest\" WHERE \"accountId\" = ";
        balanceUpdate = "UPDATE public.\"AccountsTest\" SET amount = ? where \"accountId\" = ?";
        accountInsert = "Insert into public.\"AccountsTest\" (\"accountId\", amount) VALUES ( 111, 40000)";
    }

    public Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(urlHostname, userName, userPass);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public void isDbExistChecker() {
        try {
            Connection dbConnection = getDBConnection();
            PreparedStatement statement = dbConnection.prepareStatement(createTableSQL);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer findAccountInDb(int accountId) {
        Statement statement = null;
        Connection dbConnection = null;
        ResultSet rs = null;
        String amount = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            rs = statement.executeQuery(balanceSelect + accountId);
            while (rs.next()) {
                amount = rs.getString("amount");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(amount);
    }

    public void updateAccountInDb(int accountId, int finalAmount) {
        try {
            Connection dbConnection = getDBConnection();
            balanceUpdate = "UPDATE public.\"AccountsTest\" SET amount = " + finalAmount + " where \"accountId\" = " + accountId;
            PreparedStatement statement = dbConnection.prepareStatement(balanceUpdate);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
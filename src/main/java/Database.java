import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL  = "jdbc:postgresql://localhost:5432/todo_jdbc_demo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "userSQL$";

    // méthode pour ouvrir une connexion à la base de données postgresql
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

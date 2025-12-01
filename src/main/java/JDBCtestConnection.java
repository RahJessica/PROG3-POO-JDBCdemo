import java.sql.Connection;
import java.sql.DriverManager;

// ouverture d'une session de connexion à la base de données postgresql
public class JDBCtestConnection {
    public static void main(String[] args) {
        String url  = "jdbc:postgresql://localhost:5432/todo_jdbc_demo";
        String user = "postgres";
        String password = "userSQL$";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie !");
            conn.close();
        }
        // récupération des erreurs dans le try et affiche les détails dans la console
            catch (Exception e) {
            e.printStackTrace();
        }
    }
}

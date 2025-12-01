import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadTodo {
    public static void main(String[] args) {
        String sql = "SELECT id, title, datetime, description, isCompleted FROM todo";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);

             // objet ResultSet qui contient toutes les lignes retournées par la base
             ResultSet rs = stmt.executeQuery()) {

            // parcourt les lignes si true (true = nouvelle ligne existe)
            while (rs.next()) {
                System.out.println("Tasks list : ");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Title : " + rs.getString("title"));
                System.out.println("Date et heure : " + rs.getTimestamp("datetime"));
                System.out.println("Description : " + rs.getString("description"));
                System.out.println("Is Completed : " + rs.getBoolean("isCompleted"));
                System.out.println("---------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

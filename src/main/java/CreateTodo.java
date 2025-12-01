import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateTodo {
    public static void main(String[] args) {
        String sql = "INSERT INTO todo (title, datetime, description, isCompleted) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "Finir mon projet PROG3");
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf("2025-12-01 15:30:30"));
            stmt.setString(3, "JDBC connectivity");
            stmt.setBoolean(4, false);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " ligne(s) insérée(s)");

            stmt.setString(1, "Changer de cache-ecran");
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf("2025-11-04 11:30:50"));
            stmt.setString(3, "Acheter chez TechStore");
            stmt.setBoolean(4, true);

            rows = stmt.executeUpdate();
            System.out.println(rows + " ligne(s) insérée(s)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

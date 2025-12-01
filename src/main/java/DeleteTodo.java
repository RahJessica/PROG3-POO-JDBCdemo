import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteTodo {
    public static void main(String[] args) {
        String sql = "DELETE FROM todo WHERE id = ?";

        try (
                Connection conn = Database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, 2);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " ligne(s) supprimée(s).");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

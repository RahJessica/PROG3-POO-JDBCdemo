import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// stocker toutes les requêtes SQL
public class TodoRepository {

        public void createTodos(ToDo todo) {
            String sql = "INSERT INTO todo (title, datetime, description, isCompleted) VALUES (?, ?, ?, ?)";

            try (Connection conn = Database.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, todo.getTitle());
                stmt.setTimestamp(2, java.sql.Timestamp.from(todo.getDateTime()));
                stmt.setString(3, todo.getDescription());
                stmt.setBoolean(4, todo.getIsCompleted());

                int rows = stmt.executeUpdate();
                System.out.println(rows + " todo(s) ajouté(s)");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void readAll() {
            String sql = "SELECT id, title, datetime, description, isCompleted FROM todo";

            try (Connection conn = Database.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                System.out.println("Tasks list : ");

                while (rs.next()) {
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

        public void deleteById(int id) {
            String sql = "DELETE FROM todo WHERE id = ?";

            try (Connection conn = Database.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                int rows = stmt.executeUpdate();
                System.out.println(rows + " ligne(s) supprimée(s).");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

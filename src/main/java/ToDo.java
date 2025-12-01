import java.time.Instant;

public class ToDo {
    private final Integer id;
    private final String title;
    private final Instant dateTime;
    private final String description;
    private final Boolean isCompleted;

    public ToDo(Integer id, String title, Instant dateTime, String description, Boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public static void main(String[] args) {
        TodoRepository repository = new TodoRepository();

        ToDo toDo1 = new ToDo(
                1,
                "Finir mon devoir de PROG3",
                Instant.parse("2025-12-02T10:00:00Z"),
                "JDBC Connectivity",
                false
        );

        ToDo toDo2 = new ToDo(
                2,
                "Faire les courses",
                Instant.parse("2025-12-20T11:00:00Z"),
                "Achats de noel",
                false
        );

        ToDo toDo3 = new ToDo(
                3,
                "Changer de cache-ecran",
                Instant.parse("2025-09-11T08:30:00Z"),
                "Acheter un modèle gel et teinté chez Tech Store",
                true
        );

        /*
            repository.createTodos(toDo1);
            repository.createTodos(toDo2);
            repository.createTodos(toDo3);
        */

        repository.readAll();

        // repository.deleteById(3);
    }

}

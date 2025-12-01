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
}

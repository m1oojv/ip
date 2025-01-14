package sam.tasks;

/**
 * Represents a ToDo in the Task list.
 */
public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFileString() {
        return "T " + super.toFileString();
    }
}
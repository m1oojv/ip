package sam.commands;

import sam.constants.Message;
import sam.services.Storage;
import sam.services.TaskList;
import sam.services.UI;
import sam.tasks.Task;
import sam.tasks.Todo;

import java.io.IOException;

/**
 * Adds a todo to the task list.
 */
public class AddTodoCommand extends Command {

    public static final String COMMAND_WORD = "todo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a todo to the task list. \n"
            + "Example: " + COMMAND_WORD
            + " borrow books";
    private String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        try {
            Task todo = new Todo(description);
            tasks.addTask(todo);
            ui.printMessage(Message.ADD_TASKS, "\t" + todo, tasks.taskCountSummary());
            storage.saveTasksToFile(tasks);
        } catch (IOException e) {
            ui.showError(Message.FAILED_TO_SAVE + e.getMessage());
        }
    }

}

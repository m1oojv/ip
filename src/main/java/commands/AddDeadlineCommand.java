package commands;

import constants.Message;
import services.Storage;
import services.TaskList;
import services.UI;
import tasks.Deadline;
import tasks.Task;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Adds a person to the address book.
 */
public class AddDeadlineCommand extends Command {

    public static final String COMMAND_WORD = "deadline";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a deadline to the task list. \n"
            + "Parameters: DESCRIPTION /by DATETIME \n"
            + "Example: " + COMMAND_WORD
            + " return homework /by 2023-11-15 0800 ";
    private String description;
    private LocalDateTime by;

    public AddDeadlineCommand(String description, LocalDateTime by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        try {
            Task deadline = new Deadline(this.description, this.by);
            tasks.addTask(deadline);
            ui.printMessage(Message.ADD_TASKS, "\t" + deadline, tasks.taskCountSummary());
            storage.saveTasksToFile(tasks);
        } catch (IOException e) {
            ui.showError(Message.FAILED_TO_SAVE + e.getMessage());
        }
    }

}


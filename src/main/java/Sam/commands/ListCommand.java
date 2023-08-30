package sam.commands;

import sam.constants.Message;
import sam.exceptions.DukeException;
import sam.services.Storage;
import sam.services.TaskList;
import sam.services.UI;

/**
 * List all tasks from the task list.
 */
public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": list the tasks in the task list.\n"
            + "Example: " + COMMAND_WORD;

    public ListCommand() {
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        try {
            String list = tasks.listTasks();
            ui.printMessage(Message.LIST_TASKS, list);
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        }
    }
}


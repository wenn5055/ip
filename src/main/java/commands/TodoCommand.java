package commands;

import taskstuff.Todo;
import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;
import storage.Storage;

import exceptions.DawaeException;
import exceptions.DawaeMissingArgumentException;

public class TodoCommand extends Command {
    private final String args;
    public TodoCommand(String args) {
        this.args = args;
    }
    
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        if (args.isBlank()) throw new DawaeMissingArgumentException("Brah, give me ur task description...\uD83D\uDE44");
        Task t = new Todo(args.trim());
        tasks.addTask(t);
        ui.showAdded(t, tasks.size());
        storage.save(tasks);
        return true;
    }
}
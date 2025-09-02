package commands;
import taskstuff.Deadline;
import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;
import storage.Storage;

import exceptions.DawaeException;
import exceptions.DawaeMissingArgumentException;

public class DeadlineCommand extends Command {
    private final String args;
    public DeadlineCommand(String args) { this.args = args; }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        // expects: "desc /by 2025-08-31T06:30:00"
        String[] parts = args.split("/by", 2);
        if (parts.length < 2) throw new DawaeMissingArgumentException("Brah, give me ur task description...\uD83D\uDE44");
        String desc = parts[0].trim();
        String by = parts[1].trim();
        Task t = new Deadline(desc, by);
        tasks.addTask(t);
        ui.showAdded(t, tasks.size());
        storage.save(tasks);
    }
}

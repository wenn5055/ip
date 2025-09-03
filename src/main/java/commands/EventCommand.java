package commands;

import taskstuff.Event;
import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;
import storage.Storage;

import exceptions.DawaeException;
import exceptions.DawaeMissingArgumentException;

public class EventCommand extends Command {
    private final String args;
    public EventCommand(String args) { this.args = args; }
    
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        // expects: "desc /from 2025-08-20T06:30:00 /to 2025-08-20T08:30:00"
        String[] a = args.split("/from", 2);
        
        if (a.length < 2) throw new DawaeMissingArgumentException("Brah, give me ur task description...\uD83D\uDE44");
        String desc = a[0].trim();
        String[] b = a[1].split("/to", 2);
        if (b.length < 2) throw new DawaeMissingArgumentException("Brah, give me ur task description...\uD83D\uDE44");
        String from = b[0].trim();
        String to = b[1].trim();
        Task t = new Event(desc, from, to);
        tasks.addTask(t);
        ui.showAdded(t, tasks.size());
        storage.save(tasks);
        return true;
    }
}

package commands;

import exceptions.DawaeException;
import storage.Storage;
import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;

public class MarkCommand extends Command {
    private final String args;
    
    public MarkCommand(String args) {
        this.args = args;
    }
    
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        try {
            int idx = Integer.parseInt(args.trim()) - 1;
            Task t = tasks.get(idx);
            t.markDone();
            ui.showUnmarked(t, tasks.size()); // reuse message style; adjust if you have a dedicated done message
            storage.save(tasks);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DawaeException("Usage: done <taskNumber>");
        }
        return true;
    }
}

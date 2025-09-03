package commands;

import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;
import storage.Storage;

import exceptions.DawaeException;

public class UnmarkCommand extends Command {
    private final String args;
    
    /** {@inheritDoc} */
    public UnmarkCommand(String args) {
        this.args = args;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        try {
            int idx = Integer.parseInt(args.trim()) - 1;
            Task t = tasks.get(idx);
            t.unmarkDone();
            ui.showUnmarked(t, tasks.size());
            storage.save(tasks);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DawaeException("Usage: done <taskNumber>");
        }
        return true;
    }
}

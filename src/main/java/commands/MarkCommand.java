package commands;

import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;
import storage.Storage;

import exceptions.DawaeException;

public class MarkCommand extends Command {
    private final String args;
    
    /**
     * Creates a done command with raw arguments (usually the 1-based task index).
     *
     * @param args the raw argument string from the user input.
     */
    public MarkCommand(String args) {
        this.args = args;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        try {
            int idx = Integer.parseInt(args.trim()) - 1;
            Task t = tasks.get(idx);
            t.markDone();
            ui.showMarked(t, tasks.size()); // reuse message style; adjust if you have a dedicated done message
            storage.save(tasks);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DawaeException("Usage: done <taskNumber>");
        }
        return true;
    }
}

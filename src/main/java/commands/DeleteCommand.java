package commands;

import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;
import storage.Storage;

import exceptions.DawaeException;

public class DeleteCommand extends Command {
    private final String args;
    
    /**
     * Creates a delete command with raw arguments (usually the 1-based task index).
     *
     * @param args the raw argument string from the user input.
     */
    public DeleteCommand(String args) { this.args = args; }
    
    /** {@inheritDoc} */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        try {
            int idx = Integer.parseInt(args.trim()) - 1;
            Task removed = tasks.deleteTask(idx);
            ui.showDeleted(removed, tasks.size());
            storage.save(tasks);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DawaeException("Usage: delete <taskNumber>");
        }
        return true;
    }
}
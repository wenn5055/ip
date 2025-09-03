package commands;

import exceptions.DawaeException;
import storage.Storage;
import taskstuff.TaskList;
import ui.Ui;

public class ExitCommand extends Command {
    /** {@inheritDoc} */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        ui.showBye();
        return true;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean isExit() { return true; }
}

package commands;

import taskstuff.TaskList;
import ui.Ui;
import storage.Storage;

import exceptions.DawaeException;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        ui.showBye();
    }
    
    @Override
    public boolean isExit() { return true; }
}

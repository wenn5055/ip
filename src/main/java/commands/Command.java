package commands;

import exceptions.DawaeException;
import storage.Storage;
import taskstuff.TaskList;
import ui.Ui;

public abstract class Command {
    
    public abstract boolean execute(TaskList taskList, Ui ui, Storage storage) throws DawaeException;
    
    public boolean isExit() {
        return false;
    }
}

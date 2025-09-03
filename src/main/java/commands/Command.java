package commands;

import exceptions.DawaeException;
import taskstuff.TaskList;
import ui.Ui;
import storage.Storage;

public abstract class Command {
    public abstract boolean execute(TaskList taskList, Ui ui, Storage storage) throws DawaeException;
    public boolean isExit() {return false;}
}

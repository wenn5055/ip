package commands;

import storage.Storage;
import taskstuff.TaskList;
import ui.Ui;

public class ListCommand extends Command {
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showList(tasks);
        return true;
    }
}
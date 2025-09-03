import java.io.IOException;
import java.util.ArrayList;

import commands.Command;
import exceptions.DawaeException;
import parser.Parser;
import storage.Storage;
import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;

public class Dawae {
    private final Storage storage;
    private TaskList taskList;
    private final Ui ui;
    
    public Dawae(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            ArrayList<Task> storageArr= this.storage.load();
            this.taskList = new TaskList(storageArr);
        } catch (IOException e) {
            this.ui.showLoadingError();
        } catch (DawaeException e) {
            this.ui.showError(e.getMessage());
        }
    }
    
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = this.ui.readCommand();
                this.ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(this.taskList, this.ui, this.storage);
                isExit = c.isExit();
            } catch (DawaeException e) {
                this.ui.showError(e.getMessage());
            } finally {
                this.ui.showLine();
            }
        }
    }
    
    public static void main(String[] args) {
        new Dawae("Dawaetasks.txt").run();
    }
}
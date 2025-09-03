import commands.Command;
import exceptions.DawaeException;
import parser.Parser;
import storage.Storage;
import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;

import java.io.*;
import java.util.ArrayList;

public class Dawae {
    private final Storage storage; // deals with loading tasks from the file and saving tasks in the file
    private TaskList taskList; // contains the task list e.g., it has operations to add/delete tasks in the list
    private final Ui ui; // deals with interactions with the user
    
    public Dawae(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        //System.out.println("heyyy");
        try {
            ArrayList<Task> storageArr= this.storage.load();
            //System.out.println("loll");
            this.taskList = new TaskList(storageArr);
            //System.out.println("meow");
        } catch (IOException e) {
            //System.out.println("yo");
            this.ui.showLoadingError();
        } catch (DawaeException e) {
            //System.out.println("breah");
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
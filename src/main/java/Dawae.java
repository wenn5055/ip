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
    
    /**
     * Creates the application instance and initializes UI, storage, and task list.
     * Loads tasks from the specified file if available; otherwise starts with an empty list.
     *
     * @param filePath path to the save file (e.g., {@code Dawaetasks.txt}).
     */
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
    
//    /**
//     * Runs the main interaction loop of the application.
//     * Continuously reads commands, executes them, and prints responses until exit.
//     */
//    public void run() {
//        ui.showWelcome();
//        boolean isExit = false;
//        while (!isExit) {
//            try {
//                String fullCommand = this.ui.readCommand();
//                this.ui.showLine();
//                Command c = Parser.parse(fullCommand);
//                c.execute(this.taskList, this.ui, this.storage);
//                isExit = c.isExit();
//            } catch (DawaeException e) {
//                this.ui.showError(e.getMessage());
//            } finally {
//                this.ui.showLine();
//            }
//        }
//    }
    public void run() {
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
    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        try {
            this.ui.showLine();
            Command c = Parser.parse(input);
            return c.execute(this.taskList, this.ui, this.storage);
        } catch (DawaeException e) {
            this.ui.showError(e.getMessage());
            return e.getMessage();
        } finally {
            this.ui.showLine();
        }
    }
    
//    /**
//     * Application entry point.
//     *
//     * @param args command-line arguments; unused.
//     */
//    public static void main(String[] args) {
//        new Dawae("Dawaetasks.txt").run();
//    }
}
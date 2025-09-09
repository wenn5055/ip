package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.DawaeException;
import parser.Parser;
import taskstuff.Task;
import taskstuff.TaskList;

public class Storage {
    public final String FILEPATH;
    
    public Storage(String filepath) {
        this.FILEPATH = filepath;
    }
    
    /**
     * Loads tasks from the backing file if it exists.
     * Creates the data directory if necessary.
     *
     * @return a list of tasks reconstructed from the save file; empty if file missing.
     * @throws DawaeException if the file cannot be read or parsed.
     */
    public ArrayList<Task> load() throws IOException, DawaeException {
        ArrayList<Task> taskList = new ArrayList<>();
        File f = new File(FILEPATH); // just a file obj
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                Task task = Parser.parseSaved(line);
                if (task != null) {
                    taskList.add(task);
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            f.createNewFile();
            return taskList;
        }
        return taskList;
    }
    
    /**
     * Saves the given task list to the backing file in a line-based format.
     * Creates the data directory if necessary.
     *
     * @param tasks the tasks to persist.
     * @throws DawaeException if writing to the file fails.
     */
    public void save(TaskList tasks) throws DawaeException {
        try (FileWriter fw = new FileWriter(FILEPATH.toString())) {
            for (int i = 0; i < tasks.size(); i++) {
                fw.write(tasks.get(i).toDataFile() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
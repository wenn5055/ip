import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath;
    
    public Storage(String filePath) {
        this.filePath = filePath;
    }
    public ArrayList<Task> load() throws IOException, DawaeException {
        ArrayList<Task> taskList = new ArrayList<>();
        File f = new File(filePath); // just a file obj
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
    
    public void save(TaskList tasks) throws DawaeException {
        try (FileWriter fw = new FileWriter(filePath.toString())) {
            for (int i = 0; i < tasks.size(); i++) {
                fw.write(tasks.get(i).toDataFile() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
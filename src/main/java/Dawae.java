import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dawae {
    public static ArrayList<Task> taskList = new ArrayList<>();
    private static final String line = "____________________________________________________________";
    
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;
    
    private static void retrieveData() throws IOException {
        File f = new File("DawaeTasks.txt"); // just a file obj
        if (f.exists()) {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                    Task task = getTaskFromString(line);
                    if (task != null) {
                        taskList.add(task);
                    }
                }
            s.close();
        } else {
            f.createNewFile();
        }
    }
    
    private static Task getTaskFromString(String line) {
        Task task = null;
        char taskCode = line.charAt(0);
        String[] splitted = line.split(" \\| ");
        boolean done = splitted[1].equals("1");
        String desc = splitted[2];
        switch(taskCode) {
            case 'T':
                task = new Todo(desc);
                break;
            case 'D':
                String byString = splitted[3];
                task = new Deadline(desc, byString);
                break;
            case 'E':
                String fromString = splitted[3];
                String toString = splitted[4];
                task = new Event(desc, fromString, toString);
                break;
        }
        if (done) task.markDone();
        return task;
    }
    
    private static void addData(Task task) {
        try (FileWriter writer = new FileWriter("DawaeTasks.txt", true)) {
            writer.write(task.toDataFile());
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error adding task to file: " + e.getMessage());
        }
    }
    
    private static void updateData(int taskIndex, Task updatedTask) {
        File file = new File("DawaeTasks.txt");
        if (!file.exists()) return;
        
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file for update: " + e.getMessage());
            return;
        }
        
        if (taskIndex >= 0 && taskIndex < lines.size()) {
            lines.set(taskIndex, updatedTask.toDataFile());
        }
        
        try (FileWriter writer = new FileWriter(file)) {
            for (String line : lines) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error updating file: " + e.getMessage());
        }
    }
    
    /**
     * DELETE DATA: Remove specific line from file
     */
    private static void deleteData(int taskIndex) {
        File file = new File("DawaeTasks.txt");
        if (!file.exists()) return;
        
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file for deletion: " + e.getMessage());
            return;
        }
        
        if (taskIndex >= 0 && taskIndex < lines.size()) {
            lines.remove(taskIndex);
        }
        
        try (FileWriter writer = new FileWriter(file)) {
            for (String line : lines) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error deleting from file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) throws IOException {
        //setting up
        Scanner sc = new Scanner(System.in);
        String inputt = "";
        String[] splitted;
        String desc = "";
        
        retrieveData();
        
        System.out.println(
                line + "\n" +
                " Hello! I'm DAWAE \uD83D\uDE06\n" +
                " What can I do for you?\n" +
                line);
        do {
            try {
                inputt = sc.nextLine();
                System.out.println(line);
                if (inputt.isEmpty()) throw new DawaeMissingArgumentException("Brah. Why never say anything.\uD83D\uDE10");
                splitted = inputt.split(" ");
            
                if (!inputt.equals("bye")) {
                    if (inputt.equals("list")) {
                        System.out.println("Here are the tasks in your list! :]");
                        for (int j = 1; j <= taskList.size(); j++) {
                            Task task = taskList.get(j - 1);
                            System.out.println(j + ". " + task.toString());
                        }
                    } else if (splitted[0].equals("mark")) {
                        int idx = Integer.parseInt(splitted[1]) - 1;
                        Task task = taskList.get(idx);
                        System.out.println(task.markDone());
                        updateData(idx, task);
                    } else if (splitted[0].equals("unmark")) {
                        int idx = Integer.parseInt(splitted[1]) - 1;
                        Task task = taskList.get(idx);
                        System.out.println(task.unmarkDone());
                        updateData(idx, task);
                    } else if (splitted[0].equals("delete")) {
                        int idx = Integer.parseInt(splitted[1]) - 1;
                        Task task = taskList.get(idx);
                        taskList.remove(task);
                        System.out.println(task.deleteTaskMsg());
                        deleteData(idx);
                    }else { // need to see which kind to create
                        Task task;
                        if (splitted[0].equals("Todo")) {
                            desc = inputt.substring(4).trim();
                            task = new Todo(desc);
                        } else if (splitted[0].equals("Deadline")) {
                            int byPos = inputt.indexOf("/by ");
                            if (byPos == -1) throw new DawaeMissingArgumentException("give deadline pls brah");
                            desc = inputt.substring(8, byPos).trim();
                            String byString = inputt.substring(byPos + 4).trim();
                            task = new Deadline(desc, byString);
                        } else if (splitted[0].equals("Event")) {
                            int fromPos = inputt.indexOf("/from ");
                            int toPos = inputt.indexOf("/to ");
                            if (fromPos == -1) throw new DawaeMissingArgumentException("give start pls brah");
                            if (toPos == -1) throw new DawaeMissingArgumentException("give end pls brah");
                            desc = inputt.substring(5, fromPos).trim();
                            String fromString = inputt.substring(fromPos + 6, toPos).trim();
                            String toString = inputt.substring(toPos + 4).trim();
                            task = new Event(desc, fromString, toString);
                        } else {
                            throw new DawaeExceptions("I dont understand u. >:[");
                        }
                        if (desc.isEmpty()) throw new DawaeMissingArgumentException("Brah, give me ur task description...\uD83D\uDE44");
                        taskList.add(task);
                        addData(task);
                        System.out.println(task.addTaskMsg());
                    }
                    System.out.println(line);
                }
            } catch (DawaeExceptions e) {
                System.out.println(e);
            }
        } while (!inputt.equals("bye"));
        
        
        System.out.println(
                "Bye. \uD83D\uDC4B Hope to see you again soon! \uD83D\uDD25\n" +
                line);
        
        sc.close();
    }
}
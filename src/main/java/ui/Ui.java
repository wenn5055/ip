package ui;
import taskstuff.TaskList;
import taskstuff.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private static final String LINE = "____________________________________________________________";
    private final Scanner sc = new Scanner(System.in);
    
    public void showWelcome() {
        System.out.println(LINE);
        System.out.println("Hello! I'm DAWAE \uD83D\uDE06\nWhat can I do for you?");
        System.out.println(LINE);
    }
    
    public String readCommand() {
        return sc.nextLine();
    }
    
    public void showAdded(Task t, int count) {
        System.out.println("Ogi. I've added dis task:\n  " + t);
        System.out.println("Now you have " + count + " tasks in the list.");
    }
    
    public void showDeleted(Task t, int count) {
        System.out.println("Ogi. I've removed dis task:\n  " + t);
        System.out.println("Now u have " + count + " tasks in dis list.");
    }
    
    public void showList(TaskList tasks) {
        if (tasks.size() == 0) {
            System.out.println("Your task list is empty.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    
    public void showMarked(Task t, int count) {
        System.out.println("Ogi. I've marked dis task:\n  " + t);
    }
    
    public void showUnmarked(Task t, int count) {
        System.out.println("Ogi. I've unmarked dis task:\n  " + t);
    }
    
    public void showBye() {
        System.out.println("Bye. \uD83D\uDC4B Hope to see you again soon! \uD83D\uDD25\n");
        sc.close();
    }
    
    public void showLine() {
        System.out.println(LINE);
    }
    public void showLoadingError() {
        System.out.println("Loading Error! Having sum issues internally, sad. Restart maybe? " +
                "\uD83D\uDE36\u200D\uD83C\uDF2B\uFE0F");
    }
    
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
    
    /**
     * Shows the tasks that match a search query in their original order.
     * Displays an empty-state message if there are no matches.
     *
     * @param found the list of matching tasks.
     */
    public void showFound(ArrayList<Task> found) {
        if (found == null || found.isEmpty()) {
            System.out.println("UHm. No matching tasks found.");
            return;
        }
        System.out.println("Yo. Here are the matching tasks in your list:");
        for (int i = 0; i < found.size(); i++) {
            System.out.println((i + 1) + ". " + found.get(i));
        }
    }
}

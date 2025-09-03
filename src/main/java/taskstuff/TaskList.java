package taskstuff;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private ArrayList<Task> taskList;
    
    public TaskList(ArrayList<Task> a) {
        this.taskList = a;
    }
    
    public void list() { // shld this b ui instead
        System.out.println("Here are the tasks in your list! :]");
        for (int j = 1; j <= taskList.size(); j++) {
            Task task = taskList.get(j - 1);
            System.out.println(j + ". " + task.toString());
        }
    }
    
    public void addTask(Task task) {
        taskList.add(task);
    }
    
    public Task deleteTask(int i) {
        return taskList.remove(i);
    }
    
    public Task get(int i) {
        return taskList.get(i);
    }
    
    public int size() {
        return taskList.size();
    }

    /**
     * Returns all tasks whose descriptions contain the given keyword (case-insensitive).
     *
     * @param keyword the search keyword; leading/trailing spaces are ignored.
     * @return a new list containing matching tasks in their original order.
     * @throws IllegalArgumentException if {@code keyword} is null or blank.
     */
    public ArrayList<Task> findContaining(String keyword) {
        ArrayList<Task> out = new ArrayList<>();
        // getDescription(), use that instead of toString()
        for (Task t : taskList) {
            String desc = t.description;
            if (desc != null && desc.toLowerCase().contains(keyword)) {
                out.add(t);
            }
        }
        return out;
    }
}

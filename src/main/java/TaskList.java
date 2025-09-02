import java.util.ArrayList;

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
    
    public void mark(int i) {
    
    }
    
    public void unmark(int i) {
    
    }
    
    public Task get(int i) {
        return taskList.get(i);
    }
    
    public int size() {
        return taskList.size();
    }
}

package taskstuff;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;
    
    public TaskList(ArrayList<Task> a) {
        this.taskList = a;
    }
    
    /**
     * Adds a task to the end of the list.
     *
     * @param task the task to add.
     */
    public void addTask(Task task) {
        taskList.add(task);
    }
    
    /**
     * Removes and returns the task at the specified 0-based index.
     *
     * @param i index of the task to remove.
     * @return the removed task.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public Task deleteTask(int i) {
        return taskList.remove(i);
    }
    
    /**
     * Returns the task at the specified 0-based index.
     *
     * @param i index of the task to retrieve.
     * @return the task at the given index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public Task get(int i) {
        return taskList.get(i);
    }
    
    /**
     * Returns the number of tasks currently stored.
     *
     * @return task count.
     */
    public int size() {
        return taskList.size();
    }
}

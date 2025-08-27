public abstract class Task {
    protected String description;
    protected boolean isDone;
    
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    
    public String getStatusIcon() {
        return (isDone ? "[X] " : "[ ] "); // mark done task with X
    }
    
    public String markDone() {
        this.isDone = true;
        return "Nice! I've marked this task as done:\n [X] " + this.description;
    }
    
    public String unmarkDone() {
        this.isDone = false;
        return "OK, I've marked this task as not done yet:\n [ ] " + this.description;
    }
    
    public String addTaskMsg() {
        return "Got it. I've added this task:\n " + toString() + "\nNow you have "
                + Dawae.taskList.size() + " tasks in the list.";
    }
    
    public String deleteTaskMsg() {
        return "Noted. I've removed this task:\n " + toString() + "\nNow you have "
                + Dawae.taskList.size() + " tasks in the list.";
    }
    
    public abstract String toDataFile();
    
    @Override
    public String toString() {
        return getStatusIcon() + this.description;
    }
}

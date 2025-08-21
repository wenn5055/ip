public class Task {
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
                + Dawae.i + " tasks in the list.";
    }
    
    @Override
    public String toString() {
        return getStatusIcon() + this.description;
    }
}

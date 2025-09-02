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
    
    public abstract String toDataFile();
    
    @Override
    public String toString() {
        return getStatusIcon() + this.description;
    }
}

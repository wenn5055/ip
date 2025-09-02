class TodoCommand extends Command {
    private final String args;
    TodoCommand(String args) { this.args = args; }
    
    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        if (args.isBlank()) throw new DawaeMissingArgumentException("Brah, give me ur task description...\uD83D\uDE44");
        Task t = new Todo(args.trim());
        tasks.addTask(t);
        ui.showAdded(t, tasks.size());
        storage.save(tasks);
    }
}
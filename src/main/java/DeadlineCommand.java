public class DeadlineCommand extends Command {
    private final String args;
    DeadlineCommand(String args) { this.args = args; }
    
    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        // expects: "desc /by 2025-08-31T06:30:00"
        String[] parts = args.split("/by", 2);
        if (parts.length < 2) throw new DawaeMissingArgumentException("Brah, give me ur task description...\uD83D\uDE44");
        String desc = parts[0].trim();
        String by = parts[1].trim();
        Task t = new Deadline(desc, by);
        tasks.addTask(t);
        ui.showAdded(t, tasks.size());
        storage.save(tasks);
    }
}

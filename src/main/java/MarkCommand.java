public class MarkCommand extends Command {
    private final String args;
    MarkCommand(String args) { this.args = args; }
    
    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        try {
            int idx = Integer.parseInt(args.trim()) - 1;
            Task t = tasks.get(idx);
            t.markDone();
            ui.showAdded(t, tasks.size()); // reuse message style; adjust if you have a dedicated done message
            storage.save(tasks);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DawaeException("Usage: done <taskNumber>");
        }
    }
}

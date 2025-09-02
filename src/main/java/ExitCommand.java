class ExitCommand extends Command {
    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws DawaeException {
        ui.showBye();
    }
    
    @Override
    boolean isExit() { return true; }
}

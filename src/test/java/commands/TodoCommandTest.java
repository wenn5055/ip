package commands;

import exceptions.DawaeException;
import org.junit.jupiter.api.Test;
import storage.Storage;
import taskstuff.Task;
import taskstuff.TaskList;
import ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TodoCommandTest {
    @Test
    public void execute_noArgs_DawaeMissingArgumentExceptionThrown() {
        try {
            new TodoCommand("").execute(new TaskList(new ArrayList<>()), new Ui(), new Storage("Dawaetasks.txt"));
            fail(); // the test should not reach this line
        } catch (Exception e) {
            assertEquals("Brah, give me ur task description...\uD83D\uDE44", e.getMessage());
        }
    }
    
    @Test
    public void testExecuteSuccess() throws DawaeException {
        assertTrue(new TodoCommand("Todo Eat").execute(
                new TaskList(new ArrayList<>()), new Ui(), new Storage("Dawaetasks.txt")));
    }
}

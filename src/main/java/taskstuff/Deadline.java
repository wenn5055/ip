package taskstuff;

import java.time.LocalDateTime; // yyyy-mm-dd  ->  MMM dd yyyy
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Deadline extends Task {
    
    protected LocalDateTime by;
    protected String byString;
    
    public Deadline(String description, String byString) {
        super(description);
        this.byString = byString;
        this.by = LocalDateTime.parse(byString); // 2015-02-20T06:30:00;
    }
    
    @Override
    public String toDataFile() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | "
                + this.byString;
    }
    
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + ")";
    }
}

//"2015-02-20T06:30:00"
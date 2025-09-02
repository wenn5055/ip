package taskstuff;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Event extends Task{
    protected String fromString;
    protected String toString;
    protected LocalDateTime from;
    protected LocalDateTime to;
    
    public Event(String description, String fromString, String toString) {
        super(description);
        this.fromString = fromString;
        this.toString = toString;
        this.from = LocalDateTime.parse(fromString);
        this.to = LocalDateTime.parse(toString);
    }
    
    @Override
    public String toDataFile() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + this.from + " | " + this.to;
        
    }
    
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: "
                + this.from.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + " to: "
                + this.to.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + ")";
    }
}

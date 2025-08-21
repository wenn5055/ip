import java.util.Scanner;
public class Dawae {
    private static Task[] storage = new Task[100];
    public static int i = 0;
    private static final String line = "____________________________________________________________";
    
    public static void main(String[] args) {
        //setting up
        Scanner sc = new Scanner(System.in);
        String inputt;
        String[] splitted;
        
        System.out.println(
                line + "\n" +
                " Hello! I'm DAWAE \uD83D\uDE06\n" +
                " What can I do for you?\n" +
                line);
        
        do {
            inputt = sc.nextLine();
            splitted = inputt.split(" ");
            
            System.out.println(line);
            if (!inputt.equals("bye")) {
                if (inputt.equals("list")) {
                    System.out.println("Here are the tasks in your list! :]");
                    for (int j = 1; j <= i; j++) {
                        Task task = storage[j - 1];
                        System.out.println(j + ". " + task.toString());
                    }
                } else if (splitted[0].equals("mark")) {
                    System.out.println(storage[Integer.parseInt(splitted[1]) - 1].markDone());
                } else if (splitted[0].equals("unmark")) {
                    System.out.println(storage[Integer.parseInt(splitted[1]) - 1].unmarkDone());
                } else { // need to see which kind to create
                    Task task;
                    if (splitted[0].equals("Todo")) {
                        String desc = inputt.substring(5).trim();
                        task = new Todo(desc);
                    } else if (splitted[0].equals("Deadline")) {
                        int byPos = inputt.indexOf("/by ");
                        String desc = inputt.substring(9, byPos).trim();
                        String by = inputt.substring(byPos + 4).trim();
                        task = new Deadline(desc, by);
                    } else { //if (splitted[0].equals("Event ")) {
                        int fromPos = inputt.indexOf("/from ");
                        int toPos = inputt.indexOf("/to ");
                        String desc = inputt.substring(6, fromPos).trim();
                        String from = inputt.substring(fromPos + 6, toPos).trim();
                        String to = inputt.substring(toPos + 4).trim();
                        task = new Event(desc, from, to);
                    }
                    storage[i++] = task;
                    System.out.println(task.addTaskMsg());
                }
                System.out.println(line);
            }
        } while (!inputt.equals("bye"));
        
        System.out.println(
                "Bye. \uD83D\uDC4B Hope to see you again soon! \uD83D\uDD25\n" +
                line);
        
        sc.close();
    }
}

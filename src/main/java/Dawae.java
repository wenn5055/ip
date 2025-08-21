import java.util.ArrayList;
import java.util.Scanner;
public class Dawae {
    public static ArrayList<Task> taskList = new ArrayList<>();
    private static final String line = "____________________________________________________________";
    
    public static void main(String[] args) {
        //setting up
        Scanner sc = new Scanner(System.in);
        String inputt = "";
        String[] splitted;
        String desc = "";
        
        System.out.println(
                line + "\n" +
                " Hello! I'm DAWAE \uD83D\uDE06\n" +
                " What can I do for you?\n" +
                line);
        do {
            try {
                inputt = sc.nextLine();
                System.out.println(line);
                if (inputt.length() == 0) throw new DawaeMissingArgumentException("Brah. Why never say anything.\uD83D\uDE10");
                splitted = inputt.split(" ");
            
                if (!inputt.equals("bye")) {
                    if (inputt.equals("list")) {
                        System.out.println("Here are the tasks in your list! :]");
                        for (int j = 1; j <= taskList.size(); j++) {
                            Task task = taskList.get(j - 1);
                            System.out.println(j + ". " + task.toString());
                        }
                    } else if (splitted[0].equals("mark")) {
                        System.out.println(taskList.get(Integer.parseInt(splitted[1]) - 1).markDone());
                    } else if (splitted[0].equals("unmark")) {
                        System.out.println(taskList.get(Integer.parseInt(splitted[1]) - 1).unmarkDone());
                    } else if (splitted[0].equals("delete")) {
                        System.out.println(taskList.remove(Integer.parseInt(splitted[1]) - 1));
                    }else { // need to see which kind to create
                        Task task;
                        if (splitted[0].equals("Todo")) {
                            desc = inputt.substring(4).trim();
                            task = new Todo(desc);
                        } else if (splitted[0].equals("Deadline")) {
                            int byPos = inputt.indexOf("/by ");
                            if (byPos == -1) throw new DawaeMissingArgumentException("give deadline pls brah");
                            desc = inputt.substring(8, byPos).trim();
                            String by = inputt.substring(byPos + 4).trim();
                            task = new Deadline(desc, by);
                        } else if (splitted[0].equals("Event")) {
                            int fromPos = inputt.indexOf("/from ");
                            int toPos = inputt.indexOf("/to ");
                            if (fromPos == -1) throw new DawaeMissingArgumentException("give start pls brah");
                            if (toPos == -1) throw new DawaeMissingArgumentException("give end pls brah");
                            desc = inputt.substring(5, fromPos).trim();
                            String from = inputt.substring(fromPos + 6, toPos).trim();
                            String to = inputt.substring(toPos + 4).trim();
                            task = new Event(desc, from, to);
                        } else {
                            throw new DawaeExceptions("I dont understand u. >:[");
                        }
                        if (desc.length() == 0) throw new DawaeMissingArgumentException("Brah, give me ur task description...\uD83D\uDE44");
                        taskList.add(task);
                        System.out.println(task.addTaskMsg());
                    }
                    System.out.println(line);
                }
            } catch (DawaeExceptions e) {
                System.out.println(e.toString());
            }
        } while (!inputt.equals("bye"));
        
        
        System.out.println(
                "Bye. \uD83D\uDC4B Hope to see you again soon! \uD83D\uDD25\n" +
                line);
        
        sc.close();
    }
}
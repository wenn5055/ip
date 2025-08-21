import java.util.Scanner;
public class Dawae {
    public static void main(String[] args) {
        //setting up
        Scanner sc = new Scanner(System.in);
        Task[] storage = new Task[100];
        int i = 0;
        final String line = "____________________________________________________________";
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
                        System.out.println(j + ". " + task.getStatusIcon() + task.description);
                    }
                } else if (splitted[0].equals("mark")) {
                    System.out.println(storage[Integer.parseInt(splitted[1]) - 1].markDone());
                } else if (splitted[0].equals("unmark")) {
                    System.out.println(storage[Integer.parseInt(splitted[1]) - 1].unmarkDone());
                } else {
                    storage[i++] = new Task(inputt);
                    System.out.println("added: " + inputt);
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

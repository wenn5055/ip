import java.util.Scanner;
public class Dawae {
    public static void main(String[] args) {
        //setting up
        Scanner sc = new Scanner(System.in);
        String[] storage = new String[100];
        int i = 0;
        final String line = "____________________________________________________________";
        String inputt;
        
        System.out.println(
                line + "\n" +
                " Hello! I'm DAWAE \uD83D\uDE06\n" +
                " What can I do for you?\n" +
                line);
        
        do {
            inputt = sc.nextLine();
            System.out.println(line);
            if (!inputt.equals("bye")) {
                if (inputt.equals("list")) {
                    for (int j = 1; j <= i; j++) {
                        System.out.println(j + ". " + storage[j - 1]);
                    }
                } else {
                    storage[i++] = inputt;
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

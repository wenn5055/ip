import java.util.Scanner;
public class Dawae {
    public static void main(String[] args) {
        //setting up
        Scanner sc = new Scanner(System.in);
        String[] storage = new String[100];
        int i = 0;
        
        System.out.println(
                "____________________________________________________________\n" +
                " Hello! I'm DAWAE \uD83D\uDE06\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n");
        String inputt = sc.nextLine();
        
        System.out.println("____________________________________________________________");
        while (!inputt.equals("bye")) {
            if (!inputt.equals("list")) {
                storage[i++] = inputt;
                System.out.println("added: " + inputt);
            } else {
                for (int j = 1; j <= i; j++) {
                    System.out.println(j + ". " + storage[j-1]);
                }
            }
            System.out.println("____________________________________________________________");
            inputt = sc.nextLine();
            System.out.println("____________________________________________________________");
        }
        System.out.println(
                " Bye. \uD83D\uDC4B Hope to see you again soon! \uD83D\uDD25\n" +
                "____________________________________________________________");
        
        sc.close();
    }
}

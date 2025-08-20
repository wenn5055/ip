import java.util.Scanner;
public class Dawae {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "____________________________________________________________\n" +
                " Hello! I'm DAWAE \uD83D\uDE06\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n");
        String inputt = sc.nextLine();
        System.out.println("____________________________________________________________\n");
        while (!inputt.equals("bye")) {
            System.out.println(inputt + "\n____________________________________________________________\n");
            inputt = sc.nextLine();
            System.out.println("____________________________________________________________\n");
        }
        System.out.println(
                " Bye. \uD83D\uDC4B Hope to see you again soon! \uD83D\uDD25\n" +
                "____________________________________________________________\n");
        sc.close();
    }
}

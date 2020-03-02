package lesson_12.warmup_01;

import java.util.Scanner;

public class warmup_01 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String sent = sc.nextLine();
    while (!sent.toLowerCase().equals("quit")) {
      System.out.printf("Answer is: %d\n", findAnswer(sent));
      sent = sc.nextLine();
    }
    System.out.print("Good bye...");
  }

  public static int findAnswer(String s) {
    if (s.contains("+"))
      return parseFromHead(s, "+") + parseFromBreak(s, "+");
    else if (s.contains("-"))
      return parseFromHead(s, "-") - parseFromBreak(s, "-");
    else if (s.contains("*"))
      return parseFromHead(s, "*") * parseFromBreak(s, "*");
    else
      return parseFromHead(s, "/") / parseFromBreak(s, "/");
  }

  public static int parseFromHead(String s, String c) {
    return Integer.parseInt(s.substring(0, s.indexOf(c)));
  }

  public static int parseFromBreak(String s, String c) {
    return Integer.parseInt(s.substring(s.indexOf(c) + 1));
  }
}
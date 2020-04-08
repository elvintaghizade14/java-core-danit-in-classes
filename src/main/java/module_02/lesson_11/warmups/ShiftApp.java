package module_02.lesson_11.warmups;

import java.util.Scanner;

public class ShiftApp {
  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    // 1. input
    String s = sc.nextLine();
    int toLeft = sc.nextInt();
    int toRight = sc.nextInt();

    // 2. process
    String ans = shift(s, toLeft, toRight);

    // 3. output
    System.out.println(ans);
  }

  private static String shift(String s, int toLeft, int toRight) {
    String res = (toLeft > 0 ? shiftLeft(s, toLeft) : shiftRight(s, Math.abs(toLeft)));
    return (toRight > 0) ? shiftRight(res, toRight) : shiftLeft(res, Math.abs(toRight));
  }

  private static String shiftLeft(String s, int toLeft) {
    return shiftRight(s, s.length() - toLeft);
  }

  private static String shiftRight(String s, int toRight) {
    return String.format("%s%s", s.substring(toRight), s.substring(0, toRight));
  }
}
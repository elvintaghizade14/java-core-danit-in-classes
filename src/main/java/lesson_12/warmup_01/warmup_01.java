package lesson_12.warmup_01;

import java.util.Scanner;

public class warmup_01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sent = sc.nextLine();

    int brPoint = findOperator(sent);
    char o = sent.charAt(brPoint);

    int num1 = Integer.parseInt(sent.substring(0, brPoint));
    int num2 = Integer.parseInt(sent.substring(brPoint + 1));
    int ans = findAnswer(num1, num2, o);

    System.out.printf("Answer is: %d",ans);
  }

  private static int findAnswer(int n1, int n2, char o) {
    switch (o){
      case '+': return n1+n2;
      case '-': return n1-n2;
      case '*': return n1*n2;
      default: return n1/n2;
    }
  }

  public static int findOperator(String s) {
    if (s.contains("+")) return s.indexOf("+");
    else if (s.contains("-")) return s.indexOf("-");
    else if (s.contains("*")) return s.indexOf("*");
    else return s.indexOf("/");
  }
}
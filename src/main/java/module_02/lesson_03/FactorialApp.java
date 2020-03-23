package module_02.lesson_03;

import java.util.Scanner;

public class FactorialApp {
  private static int fact(int n) {
    return (n == 1 || n ==0) ? 1 : n * fact(n - 1);
  }

  public static void main(String[] args) {
    System.out.print("Enter a number:  ");
    int f5 = fact(new Scanner(System.in).nextInt());
    System.out.printf("Factorial: %d\n", f5);
  }
}
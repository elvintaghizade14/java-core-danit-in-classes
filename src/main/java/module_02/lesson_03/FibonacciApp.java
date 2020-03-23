package module_02.lesson_03;

import java.util.Scanner;

public class FibonacciApp {

  private static int fib(int num) {
    if (num == 0) throw new IllegalArgumentException("Wrong value!");
    return (num == 1 || num == 2) ? 1 : fib(num - 1) + fib(num - 2);
  }

  public static void main(String[] args) {
    System.out.print("Enter a number:  ");
    System.out.printf("Fibonacci: %d\n", fib(new Scanner(System.in).nextInt()));
  }
}

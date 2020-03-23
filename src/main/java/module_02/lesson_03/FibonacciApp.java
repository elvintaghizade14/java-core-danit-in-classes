package module_02.lesson_03;

import java.util.Scanner;

public class FibonacciApp {

  private static int fibo(int num) {
    if (num == 0) throw new IllegalArgumentException("Wrong value!");
    return (num == 1 || num == 2) ? 1 : fibo(num - 1) + fibo(num - 2);
  }

  public static void main(String[] args) {
    System.out.print("Enter a number:  ");
    System.out.printf("Fibonacci: %d\n",
            fibo(new Scanner(System.in).nextInt()));
  }
}

package module_02.lesson_03;

import java.util.Scanner;

public class SequenceApp {
  public static void main(String[] args) {
    System.out.print("Enter a number:  ");
    int num = new Scanner(System.in).nextInt();
    System.out.printf("Sum: %d\n", (1 + num) * (num) / 2);
  }
}
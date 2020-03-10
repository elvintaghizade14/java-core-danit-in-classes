package Step_Project_11.console_operations;

import java.util.Scanner;

public class ConsoleApp implements Console {
  Scanner sc = new Scanner(System.in);

  @Override
  public void print(String line) {
    System.out.print(line);
  }

  @Override
  public String readLn() {
    return sc.nextLine();
  }
}

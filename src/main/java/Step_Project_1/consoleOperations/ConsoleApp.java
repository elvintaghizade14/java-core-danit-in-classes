package Step_Project_1.consoleOperations;

import java.util.Scanner;

public class ConsoleApp implements Console{
  Scanner sc = new Scanner(System.in);

  @Override
  public void printLn(String line) {
    System.out.println(line);
  }

  @Override
  public String readLn() {
    return sc.nextLine();
  }
}

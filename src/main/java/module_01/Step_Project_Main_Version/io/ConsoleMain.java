package module_01.Step_Project_Main_Version.io;

import java.util.Scanner;

public class ConsoleMain implements Console {

  private Scanner sc = new Scanner(System.in);

  @Override
  public void print(String line) {
    System.out.print(line);
  }

  @Override
  public String readLn() {
    return sc.nextLine();
  }
}

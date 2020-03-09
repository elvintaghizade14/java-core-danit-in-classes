package Step_Project_1;

import Step_Project_1.consoleOperations.ConsoleApp;
import Step_Project_1.controllers.Controller;

public class BookingApp {

  Controller controller = new Controller();
  ConsoleApp console = new ConsoleApp();

  public BookingApp() {
  }

  protected void run() {
    while (true) {
      console.printLn(controller.showMenu());
      int menu_num = Integer.parseInt(console.readLn());
      switch (menu_num) {
        case 1:
          console.printLn(controller.getOnlineBoard());
        case 2:

        case 3:

        case 4:

        case 5:

        case 6:
      }
    }
  }
}

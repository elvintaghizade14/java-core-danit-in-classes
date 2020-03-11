package Step_Project_1;

import Step_Project_1.base_classes.Passenger;
import Step_Project_1.controllers.Controller;
import Step_Project_1.console_operations.ConsoleApp;

import java.util.ArrayList;
import java.util.List;

public class BookingApp {

  ConsoleApp console = new ConsoleApp();
  Controller controller = new Controller();

  protected void run() {
    boolean flag = true;
    while (flag) {
      console.printLn(controller.showMenu());
      int menu_num = Integer.parseInt(console.readLn());

      switch (menu_num) {
        case 1: // Online _Board
          console.printLn(controller.getOnlineBoard());
          break;

        case 2: // Show flight info
          console.printLn("Enter flight id: ");
          console.printLn(controller.getFlightInfoById(console.readLn()));
          break;

        case 3: // Search and book flight
          console.printLn("Enter destination: ");
          String dest = console.readLn();
          console.printLn("Enter date: ");
          String date = console.readLn();
          console.printLn("Enter number of people: ");
          int numOfPeople = Integer.parseInt(console.readLn());

          console.printLn(controller.searchForFlights(dest, date, numOfPeople));
          if (controller.searchForFlights(dest, date, numOfPeople).length() == 0) {
            console.print("There is no flights with the same properties");
            break;
          } else {
            console.print("Enter flight id or 0 to exit: ");
            int actionOrFlightId = Integer.parseInt(console.readLn());
            if (actionOrFlightId == 0) break;
            else {
              List<Passenger> passengers = new ArrayList<>();
              while (numOfPeople-- > 0) {
                console.printLn("Enter your name: ");
                String name = console.readLn();
                console.printLn("Enter your surname: ");
                String surname = console.readLn();
                passengers.add(new Passenger(name, surname));
              }
              controller.makeBooking(actionOrFlightId, passengers);
              break;
            }
          }

        case 4: //Cancel the booking
          console.printLn("Enter booking id: ");
          controller.cancelBooking(Integer.parseInt(console.readLn()));
          break;

        case 5: // My flights
          console.printLn("Enter your name: ");
          String name = console.readLn();
          console.printLn("Enter your name: ");
          String surname = console.readLn();
          console.printLn(controller.getMyFlights(name, surname));
          break;

        case 6: // Exit
          console.printLn("Good bye...");
          flag = false;
          break;
      }
    }
  }
}

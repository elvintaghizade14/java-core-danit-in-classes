package Step_Project_v2;

import Step_Project_v2.controller.Controller;
import Step_Project_v2.dao.DAOBookingFileText;
import Step_Project_v2.dao.DAOFlightFileText;
import Step_Project_v2.io.ConsoleMain;
import Step_Project_v2.service.Service;

import java.time.LocalDate;

public class MainApp {
  public static void main(String[] args) {

    ConsoleMain console = new ConsoleMain();
    DAOBookingFileText daoBooking = new DAOBookingFileText("bookings.txt");
    DAOFlightFileText daoFlight = new DAOFlightFileText("flights.txt");
    Service service = new Service(daoBooking, daoFlight);
    Controller controller = new Controller(console, service);

    if (controller.getAll()) {
      int i = 0;
      while (i++ < 20) {
        controller.addFlight();
      }
    }

    boolean flag = true;
    while (flag) {
      console.printLn(controller.showMenu());
      console.print("Enter menu num: \n");
      String input = console.readLn();
      switch (input) {
        case "1":
          console.printLn(controller.show());
          break;
        case "2":
          console.printLn(controller.search());
          break;
        case "3":
          console.printLn("Enter destination: ");
          String dest = console.readLn();
          console.printLn("Enter date (YYYY-MM-DD): ");
          LocalDate date = LocalDate.parse(console.readLn());
          console.printLn("Enter number of people: ");
          int numOfPeople = Integer.parseInt(console.readLn());
          console.print("\n");
          if (controller.searchForBook(dest, date, numOfPeople).length() == 0) {
            console.printLn("There is no flight with appropriate to specified conditions");
            break;
          } else {
            console.printLn(controller.searchForBook(dest, date, numOfPeople));
            console.printLn("Enter flightId to book or 0 to exit: ");
            String flightIdOrExit = console.readLn();
            if (flightIdOrExit.equals("0")) break;
            else {
              controller.book(flightIdOrExit, numOfPeople);
              break;
            }
          }
        case "4":
          console.printLn(controller.cancelBooking());
          break;
        case "5":
          console.printLn(controller.getMyFlights());
          break;
        default:
          flag = false;
          console.printLn("Good bye...");
          break;
      }
    }
  }
}

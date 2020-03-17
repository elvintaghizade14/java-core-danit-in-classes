package module_01.Step_Project_Main_Version;

import module_01.Step_Project_Main_Version.controller.Controller;
import module_01.Step_Project_Main_Version.dao.DAOBookingFileText;
import module_01.Step_Project_Main_Version.dao.DAOFlightFileText;
import module_01.Step_Project_Main_Version.ex.FlightCannotCreateException;
import module_01.Step_Project_Main_Version.ex.FlightNotFoundException;
import module_01.Step_Project_Main_Version.io.ConsoleMain;
import module_01.Step_Project_Main_Version.service.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MainApp {
  public static void main(String[] args) {

    DAOBookingFileText daoBooking = new DAOBookingFileText("bookings.txt");
    DAOFlightFileText daoFlight = new DAOFlightFileText("flights.txt");

    ConsoleMain console = new ConsoleMain();
    Service service = new Service(daoBooking, daoFlight);
    Controller controller = new Controller(console, service);

    if (controller.isFlightsFileEmpty()) {             // flights generator is in here. If flights.txt is empty,
      int i = 0;                                // this piece of code will generate 25 random flights and
      while (i++ < 25) controller.addFlight();  // it will fill flights.txt file immediately
    }

    boolean flag = true;
    while (flag) {
      console.printLn(controller.showMenu());
      console.print("Enter menu num: \n");
      String input = console.readLn();
      switch (input) {
        case "1":
          console.printLn(controller.showAllFlights());
          break;
        case "2":
          try {
            console.printLn(controller.getFlightById());
          } catch (FlightNotFoundException ex) {
            console.printLn("No flight found");
          }
          break;
        case "3":
          LocalDate date = null;
          int numOfPeople = 0;
          boolean notValid = true;
          console.printLn("Enter destination: ");
          String dest = console.readLn();             // getting destination
          while (notValid) {
            try {
              console.printLn("Enter date (YYYY-MM-DD): ");
              date = LocalDate.parse(console.readLn());
              notValid = false;
            } catch (DateTimeParseException ex) {
              console.printLn("You entered wrong value!");
              notValid = true;
            }
          }                      // getting valid date
          notValid = true;
          while (notValid) {
            try {
              console.printLn("Enter number of people: ");
              numOfPeople = Integer.parseInt(console.readLn());
              notValid = false;
            } catch (NumberFormatException ex) {
              console.printLn("You entered non-integer value!");
              notValid = true;
            }
          }                               // getting valid number of passenger
          try {
            console.printLn(controller.searchForBook(dest, date, numOfPeople));
            int flightIdOrExit = 0;
            try {
              console.printLn("Enter flightId to book or 0 to exit: ");
              flightIdOrExit = Integer.parseInt(console.readLn());
            } catch (NumberFormatException ex) {
              console.printLn("You entered non integer value!");
            }
            if (flightIdOrExit == 0) break;
            else {
              try {
                controller.book(flightIdOrExit, numOfPeople);
                console.printLn("Booking done.");
              } catch (FlightCannotCreateException ex) {
                console.printLn("Oops, there was an error while making booking...");
              }
            }
            break;
          } catch (FlightNotFoundException ex) {
            console.printLn("There is no flight for the specified conditions");
            break;
          }   // making booking or throwing my custom exception
        case "4":
          console.printLn(controller.cancelBooking());
          break;
        case "5":
          console.printLn(controller.getMyFlights());
          break;
        case "6":
          flag = false;
          console.printLn("Good bye...");
          break;
        default:
          console.printLn("You've entered wrong value");
      }
    }
  }
}

package Step_Project_v2;

import Step_Project_v2.controller.Controller;
import Step_Project_v2.dao.DAOBookingBin;
import Step_Project_v2.dao.DAOFlightBin;
import Step_Project_v2.entity.Flight;
import Step_Project_v2.helpers.FlightGenerator;
import Step_Project_v2.io.ConsoleMain;
import Step_Project_v2.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
  public static void main(String[] args) {

    ConsoleMain console = new ConsoleMain();
    DAOBookingBin daoBooking = new DAOBookingBin("bookings.bin");
//    DAOBooking daoBooking = new DAOBooking();
//    DAOBooking daoBooking = new DAOBooking();
//    DAOBooking daoBooking = new DAOBooking();
    DAOFlightBin daoFlight = new DAOFlightBin("flights.bin");

//    DAOFlight daoFlight = new DAOFlight();
//    DAOFlight daoFlight = new DAOFlight();
//    DAOFlight daoFlight = new DAOFlight();
    Service service = new Service(daoBooking, daoFlight);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
    Controller controller = new Controller(console, service);
//    Controller controller = new Controller(service);
//    Controller controller = new Controller(service);
//    Controller controller = new Controller(service);
//    controller.addFlight();
    boolean flag = true;
    while (flag) {
      console.print("Enter menu num: \n");
      String input = console.readLn();
      switch (input) {
        case "1": console.print(controller.show()); break;
        case "2": console.print(controller.search()); break;

        case "3":
          console.printLn("Enter destination: ");
          String dest = console.readLn();
          console.printLn("Enter date: ");
          LocalDate date = LocalDate.parse(console.readLn());
          console.printLn("Enter number of people: ");
          int numOfPeople = Integer.parseInt(console.readLn());
          if (controller.searchForBook(dest, date, numOfPeople).length() == 0) {
          console.print("There is no flight with appropriate to specified conditions");
          break;
        } else {
          console.print(controller.searchForBook(dest, date, numOfPeople));
          console.print("Enter flightId to book or 0 to exit: ");
          String flightIdOrExit = console.readLn();
          if(flightIdOrExit.equals("0")) break;
          else {
            controller.book(flightIdOrExit, numOfPeople);
            break;
          }
        }
        case "4": console.print(controller.cancelBooking()); break;
        case "5": console.print(controller.getMyFlights()); break;
        default:
          flag = false;
          console.print("Good bye...");
          break;
      }
    }
  }
}

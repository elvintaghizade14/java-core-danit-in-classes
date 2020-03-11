package Step_Project_1.controllers;

import Step_Project_1.base_classes.Flight;
import Step_Project_1.base_classes.Passenger;
import Step_Project_1.services.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Controller {

  Service service = new Service();

  public String showMenu() {
    return service.getMenuContents();
  }

  // menu-1
  public String getOnlineBoard() {
    return String.join("\n", service.getOnlineBoard());
  }

  // menu-2
  public String getFlightInfoById(String flightId) {
    return service.getFlightById(Integer.parseInt(flightId))
            .map(Flight::represent).orElse("No flight found.");
  }

  // menu - 3
  public String searchForFlights(String dest, String date, int numOfPeople) {
    return String.join("\n",
            service.searchForFlight(dest, LocalDate.parse(date), numOfPeople).toString());
  }

  public void makeBooking(int flightId, List<Passenger> passengers) {
    service.makeBooking(flightId, passengers);
  }

  // menu - 4
  public void cancelBooking(int bookingId) {
    service.cancelBooking(bookingId);
  }

  // menu - 5
  public String getMyFlights(String name, String surname) {
    return String.join("\n", service.getMyFlights(name.toLowerCase(), surname.toLowerCase()).toString());
  }
}

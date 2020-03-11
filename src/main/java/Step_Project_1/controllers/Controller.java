package Step_Project_1.controllers;

import Step_Project_1.services.Service;

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
  public String getFlightInfoById(int flightId) {
    return service.getFlightById(flightId);
  }

  // menu - 3
  public String searchForFlights(String dest, String date, int numOfPeople) {
    return String.join("\n", service.searchForFlight(dest, date, numOfPeople).toString());
  }

  public void makeBooking(String name, String surname, int flightId) {
    service.makeBooking(name, surname, flightId);
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

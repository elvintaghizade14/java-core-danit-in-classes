package Step_Project_11.controllers;

import Step_Project_11.services.Service;

public class Controller {

  Service service = new Service();

  public String showMenu() {
    return service.getMenuContents();
  }

  // menu-1
  public String getOnlineBoard() {
    return service.getOnlineBoard().toString();
  }

  // menu-2
  public String getFlightInfoById(int flightId) {
    return service.getFlightById(flightId);
  }

  // menu - 3
  public String searchAndBook(String dest, String date, int numOfPeople) {
    return service.searchAndBook(dest.toLowerCase(), date.toLowerCase(), numOfPeople).toString();
  }

  // menu - 4
  public void cancelBooking(int bookingId) {
    service.cancelBooking(bookingId);
  }

  // menu - 5
  public String getMyFlights(String name, String surname) {
    return service.getMyFlights(name.toLowerCase(), surname.toLowerCase()).toString();
  }
}

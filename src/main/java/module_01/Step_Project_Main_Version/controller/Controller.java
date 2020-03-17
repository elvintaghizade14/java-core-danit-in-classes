package module_01.Step_Project_Main_Version.controller;

import module_01.Step_Project_Main_Version.entity.Passenger;
import module_01.Step_Project_Main_Version.ex.BookingNotFoundException;
import module_01.Step_Project_Main_Version.ex.FlightNotFoundException;
import module_01.Step_Project_Main_Version.io.Console;
import module_01.Step_Project_Main_Version.io.ConsoleMain;
import module_01.Step_Project_Main_Version.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
  private final Service service;
  private final Console console;

  public Controller(ConsoleMain console, Service service) {
    this.service = service;
    this.console = console;
  }

  public String showMenu() {
    return service.showMenu();
  }

  // menu - 1 - show Online-Board
  public String showAllFlights() {
    List<String> allFlights = service.getAllFlights();
    return allFlights.size() != 0 ? String.join("\n", allFlights) : "Flight not found";
  }

  // menu - 2 - show flight by id
  public String getFlightById() {
    try {
      console.print("Enter flight id: ");
      return service.getFlightById(Integer.parseInt(console.readLn()));
    } catch (NumberFormatException ex) {
      return "You entered non integer value!\n";
    }
  }

  // menu - 3.1 - searching for appropriate bookable flight
  public String searchForBook(String dest, LocalDate date, int numOfPeople) {
    List<String> result = service.searchForBook(dest.toLowerCase(), date, numOfPeople);
    if (result.size() == 0) throw new FlightNotFoundException();
    else return String.join("\n", result);
  }

  // menu - 3.2 - booking - found flight above
  public void book(int flightId, int numOfPeople) {
    List<Passenger> passengers = new ArrayList<>();
    while (numOfPeople-- > 0) {
      console.print("Enter name: ");
      String name = console.readLn();
      console.print("Enter surname: ");
      String surname = console.readLn();
      passengers.add(new Passenger(name, surname));
    }
    service.book(flightId, passengers);
  }

  // menu - 4 - cancel booking by id
  public String cancelBooking() {
    try {
      console.print("Enter booking id: ");
      return service.cancelBooking(Integer.parseInt(console.readLn()));
    } catch (NumberFormatException ex) {
      return "You entered non-integer value!\n";
    } catch (BookingNotFoundException ex) {
      return "Booking not found";
    }
  }

  // menu - 5 - show all flights by passenger's info
  public String getMyFlights() {
    console.print("Enter name: ");
    String name = console.readLn();
    console.print("Enter surname: ");
    String surname = console.readLn();
    try {
      return String.join("\n", service.getMyFlights(name.toLowerCase().trim(), surname.toLowerCase().trim()));
    } catch (FlightNotFoundException ex) {
      return "Smth went wrong and flight not found";
    }
  }

  public boolean isFlightsFileEmpty() {
    return service.isFlightsFileEmpty();
  }

  public void addFlight() {
    service.addFlight();
  }
}

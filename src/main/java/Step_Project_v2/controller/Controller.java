package Step_Project_v2.controller;

import Step_Project_v2.entity.Passenger;
import Step_Project_v2.io.Console;
import Step_Project_v2.io.ConsoleMain;
import Step_Project_v2.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {
  private final Service service;
  private final Console console;

  public Controller(ConsoleMain console, Service service) {
    this.service = service;
    this.console = console;
  }

  public String show() {
    return String.join("\n", service.getAllFlights());
  }

  private Optional<Integer> isNumber(String line) {
    try {
      int tmp = Integer.parseInt(line);
      return Optional.of(tmp);
    } catch (NumberFormatException x) {
      return Optional.empty();
    }
  }

  public String search() {
    while (true) {
      Optional<Integer> input = isNumber(console.readLn());
      console.print("Enter flight id: ");
      if (input.isPresent()) {
        return service.getFlightById();
      }
      console.printLn("You entered non integer value!\n");
    }
  }

  public String searchForBook(String dest, LocalDate date, int numOfPeople) {
    return String.join("\n", service.searchForBook(dest.toLowerCase(), date, numOfPeople));
  }

  public void book(String flightId, int numOfPeople) {
    List<Passenger> passengers = new ArrayList<>();
    while (numOfPeople-- > 0) {
      console.print("Enter name: ");
      String name = console.readLn();
      console.print("Enter surname: ");
      String surname = console.readLn();
      passengers.add(new Passenger(name, surname));
    }
    service.book(Integer.parseInt(flightId), passengers);
  }

  public String cancelBooking() {
    console.print("Enter booking id: ");
    return service.cancelBooking(Integer.parseInt(console.readLn()));
  }

  public String getMyFlights() {
    console.print("Enter name: ");
    String name = console.readLn();
    console.print("Enter surname: ");
    String surname = console.readLn();
    return String.join("\n", service.getMyFlights(name.toLowerCase().trim(), surname.toLowerCase().trim()));
  }

  public void addFlight() {
    service.addFlight();
  }

  public boolean getAll() {
    return service.getAll();
  }


  public String showMenu() {
    return service.showMenu();
  }
}

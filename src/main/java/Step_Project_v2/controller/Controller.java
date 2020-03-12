package Step_Project_v2.controller;

import Step_Project_v2.entity.Flight;
import Step_Project_v2.entity.Passenger;
import Step_Project_v2.io.Console;
import Step_Project_v2.io.ConsoleMain;
import Step_Project_v2.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
  Service service;
  Console console;

  public Controller(ConsoleMain console, Service service) {
    this.service = service;
    this.console = console;
  }

  public String show() {
    return String.join("\n", service.getAllFlights());
  }

  public String search() {
    console.print("Enter flight id: ");
    return service.getFlightById(Integer.parseInt(console.readLn()));
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
    return String.join("\n", service.getMyFlights(name.toLowerCase(), surname.toLowerCase()));
  }

  public void addFlight(Flight genFlight) {
    service.assFlight(genFlight);
  }

//  public void addFlight() {
//    service.addFlight();
//  }
}

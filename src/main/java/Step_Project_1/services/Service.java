package Step_Project_1.services;

import Step_Project_1.DAO.DAO;
import Step_Project_1.DAO.DAOBookingFileText;
import Step_Project_1.DAO.DAOFlightFileText;
import Step_Project_1.DAO.DAOUserFileText;
import Step_Project_1.base_classes.Booking;
import Step_Project_1.base_classes.Flight;
import Step_Project_1.base_classes.Predicates;
import Step_Project_1.base_classes.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

  DAO<Flight> flightDAO = new DAOFlightFileText("flights.txt");
  DAO<Booking> bookingDAO = new DAOBookingFileText("bookings.txt");
  DAO<User> userDAO = new DAOUserFileText("users.txt");

  public String getMenuContents() {
    StringBuilder sb = new StringBuilder();
    return sb.append("1. Online - board\n")
            .append("2. Show the flight info\n")
            .append("3. Search and book a flight\n")
            .append("4. Cancel the booking\n")
            .append("5. My flights\n")
            .append("6. Exit")
            .toString();
  }

  // menu - 1
  public List<String> getOnlineBoard() {
    return flightDAO.getAllBy(Predicates.isBeforeSomeHours(24))
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  // menu - 2
  public String getFlightById(int flightId) {
    return flightDAO.get(flightId).map(Flight::represent).orElse("No flight found.");
  }

  // menu-3
  public List<String> searchForFlight(String dest, String date, int numOfPeople) {
    return flightDAO.getAllBy(Predicates.isBookable(dest, date, numOfPeople))
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public void makeBooking(String name, String surname, int flighId) {
    flightDAO.get(flighId).map(f -> f.getFreeSpaces() - 1);
    bookingDAO.create(new Booking(flighId, Collections.singletonList(new User(name, surname))));
  }

  // menu-4
  public void cancelBooking(int bookingId) {
    bookingDAO.delete(bookingId);
  }

  // menu-5
  public List<String> getMyFlights(String name, String surname) {
    return bookingDAO.getAllBy(Predicates.isMyFlight(name, surname))
            .stream().map(Booking::represent).collect(Collectors.toList());
  }
}
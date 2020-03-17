package module_01.Step_Project_1.services;

import module_01.Step_Project_1.dao.DAO;
import module_01.Step_Project_1.dao.DAOBookingFileText;
import module_01.Step_Project_1.dao.DAOFlightFileText;
import module_01.Step_Project_1.base_classes.Booking;
import module_01.Step_Project_1.base_classes.Flight;
import module_01.Step_Project_1.base_classes.Passenger;
import module_01.Step_Project_1.base_classes.Predicates;
import module_01.Step_Project_1.gen.FlightGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {

  DAO<Flight> flightDAO = new DAOFlightFileText("flights.txt");
  DAO<Booking> bookingDAO = new DAOBookingFileText("bookings.txt");

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
  public Optional<Flight> getFlightById(int flightId) {
    return flightDAO.get(flightId);
  }

  // menu-3
  public List<String> searchForFlight(String dest, LocalDate date, int numOfPeople) {
    return flightDAO.getAllBy(Predicates.isBookable(dest, date, numOfPeople))
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public void makeBooking(int flighId, List<Passenger> passengers) {
    flightDAO.get(flighId).map(f -> f.getFreeSpaces() - passengers.size());
    bookingDAO.create(new Booking(flighId, passengers));
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

  public void genData() {
    for (int i = 0; i < 25; i++) {
      flightDAO.create(FlightGenerator.genFlight());
    }
  }
}
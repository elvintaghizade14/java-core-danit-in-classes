package Step_Project_Main_Version.service;

import Step_Project_Main_Version.dao.DAOBookingFileText;
import Step_Project_Main_Version.dao.DAOFlightFileText;
import Step_Project_Main_Version.entity.Booking;
import Step_Project_Main_Version.entity.Flight;
import Step_Project_Main_Version.entity.Passenger;
import Step_Project_Main_Version.ex.BookingNotFoundException;
import Step_Project_Main_Version.ex.FlightCannotCreateException;
import Step_Project_Main_Version.ex.FlightNotFoundException;
import Step_Project_Main_Version.helpers.FlightGenerator;
import Step_Project_Main_Version.helpers.Predicates;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {
  DAOBookingFileText daoBooking;
  DAOFlightFileText daoFlight;

  public Service(DAOBookingFileText daoBooking, DAOFlightFileText daoFlight) {
    this.daoBooking = daoBooking;
    this.daoFlight = daoFlight;
  }

  public String showMenu() {
    StringBuilder sb = new StringBuilder();
    return sb.append("1. Online - board\n")
            .append("2. Show the flight info\n")
            .append("3. Search and book a flight\n")
            .append("4. Cancel the booking\n")
            .append("5. My flights\n")
            .append("6. Exit")
            .toString();
  }

  public List<String> getAllFlights() {
    return daoFlight.getAllBy(Predicates.isSomeHoursBefore())
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public String getFlightById(int flightId) {
    return daoFlight.get(flightId).map(Flight::represent)
            .orElseThrow(FlightNotFoundException::new);
}

  public List<String> searchForBook(String dest, LocalDate date, int numOfPeople) {
    return daoFlight.getAllBy(Predicates.isBookable(dest, date, numOfPeople))
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public void book(int flightId, List<Passenger> passengers) {
    daoBooking.create(new Booking(flightId, passengers));
    Optional<Flight> updatedFlight = daoFlight.get(flightId);
    daoFlight.delete(flightId);
    updatedFlight.ifPresent(f -> f.setFreeSpaces(f.getFreeSpaces() - passengers.size()));
    daoFlight.create(updatedFlight.orElseThrow(FlightCannotCreateException::new));
  }

  public String cancelBooking(int bookingId) {
    return daoBooking.get(bookingId).map(b -> {
      Flight newFlight = daoFlight.get(b.getFlight_id()).orElseThrow(RuntimeException::new);
      newFlight.setFreeSpaces(newFlight.getFreeSpaces() + b.getPassengers().size());
      daoBooking.delete(bookingId);
      daoFlight.delete(b.getFlight_id());
      daoFlight.create(newFlight);
      return "Booking deleted.";
    }).orElseThrow(BookingNotFoundException::new);
  }

  public List<String> getMyFlights(String name, String surname) {
    List<String> result = daoBooking.getAllBy(Predicates.isMyFlight(name, surname))
            .stream().map(Booking::represent).collect(Collectors.toList());
    if (result.size() == 0) throw new FlightNotFoundException();
    else return result;
  }

  public boolean isFlightsFileEmpty() {
    return daoFlight.getAll().size() == 0;
  }

  public void addFlight() {
    daoFlight.create(FlightGenerator.genFlight());
  }
}

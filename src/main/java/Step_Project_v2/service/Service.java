package Step_Project_v2.service;

import Step_Project_v2.dao.DAOBookingBin;
import Step_Project_v2.dao.DAOFlightBin;
import Step_Project_v2.entity.Booking;
import Step_Project_v2.entity.Flight;
import Step_Project_v2.entity.Passenger;
import Step_Project_v2.helpers.FlightGenerator;
import Step_Project_v2.helpers.Predicates;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {
  DAOBookingBin daoBooking;
  DAOFlightBin daoFlight;

  public Service(DAOBookingBin daoBookingBin, DAOFlightBin daoFlightBin) {
    this.daoBooking = daoBookingBin;
    this.daoFlight = daoFlightBin;
  }

  public List<String> getAllFlights() {
    return daoFlight.getAllBy(Predicates.isSomeHoursBefore(24))
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public String getFlightById(int flightId) {
    return daoFlight.get(flightId).map(Flight::represent)
            .orElse("No flight found");
  }

  public List<String> searchForBook(String dest, LocalDate date, int numOfPeople) {
    return daoFlight.getAllBy(Predicates.isBookable(dest, date, numOfPeople))
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public void book(int flightId, List<Passenger> passengers) {
    daoFlight.get(flightId).map(f -> f.getFreeSpaces() - passengers.size());
    daoBooking.create(new Booking(flightId, passengers));
  }

  public String cancelBooking(int bookingId) {
    Optional<Booking> booking = daoBooking.get(bookingId);
    if (booking.isPresent()) {
      Booking booking1 = daoBooking.get(bookingId).get();
      daoFlight.get(booking1.getFlight_id()).map(f -> f.getFreeSpaces() + booking1.getPassengers().size());
      daoBooking.delete(bookingId);
      return "Booking deleted.";
    } else return "There is no any booking.";
  }

  public List<String> getMyFlights(String name, String surname) {
    return daoBooking.getAllBy(Predicates.isMyFlight(name, surname))
            .stream().map(Booking::represent).collect(Collectors.toList());
  }

//  public void addFlight() {
//    daoFlight.create(FlightGenerator.genFlight());
//  }
}

package module_01.Step_Project_1.base_classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Predicate;

public class Predicates {

  // for menu - 1
  public static Predicate<Flight> isBeforeSomeHours(int hours) {
    return f -> f.getFlightTime().equals(LocalTime.now().plusHours(hours));
  }

  public static Predicate<Flight> isBookable(String dest, LocalDate date, int numOfPeople) {
    return f -> f.getFlightDate().isAfter(date) && f.getFlightDate().isBefore(date.plusDays(1)) &&
            f.getFlightDest().equals(dest) &&
            f.getFreeSpaces() >= numOfPeople;
  }

  public static Predicate<Booking> isMyFlight(String name, String surname) {
    return b -> b.getPassengers().stream().anyMatch(p -> p.getName().toLowerCase().equals(name) &&
            p.getSurname().toLowerCase().equals(surname));
  }
}
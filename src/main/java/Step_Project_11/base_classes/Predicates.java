package Step_Project_11.base_classes;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class Predicates {
  public static Predicate<Flight> isBeforeSomeHours(int hours) {
    return f -> f.getFlightDateTime().isBefore(LocalDateTime.now().plusHours(hours));
  }

  public static Predicate<Flight> isBookable(String dest, String date, int numOfPeople) {
    return f -> f.getFlightDest().equals(dest) &&
            f.getFreeSpaces() >= numOfPeople &&
            f.getFlightDateTime().toString().split("T")[0].equals(date);
  }

  public static Predicate<Booking> isMyFlight(String name, String surname) {
    return f -> f.getPassengers().forEach(u -> u.getName().equals(name) && u.getSurname().equals(surname));
  }
}
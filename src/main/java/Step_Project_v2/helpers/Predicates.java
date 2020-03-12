package Step_Project_v2.helpers;

import Step_Project_v2.entity.Booking;
import Step_Project_v2.entity.Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Predicate;

public class Predicates {

  public static Predicate<Flight> isSomeHoursBefore(int hours) {
    return f -> f.getTime().isBefore(LocalTime.now().plusHours(hours)) &&
            f.getTime().isAfter(LocalTime.now());
  }

  public static Predicate<Flight> isBookable(String dest, LocalDate date, int numOfPeople) {
    return f -> f.getFreeSpaces() >= numOfPeople &&
            f.getDest().toLowerCase().equals(dest) &&
            f.getDate().isAfter(date) && f.getDate().isBefore(date.plusDays(1));
  }

  public static Predicate<Booking> isMyFlight(String name, String surname) {
    return b -> b.getPassengers().stream().anyMatch(p ->
            p.getName().toLowerCase().equals(name) &&
            p.getSurname().toLowerCase().equals(surname));
  }
}

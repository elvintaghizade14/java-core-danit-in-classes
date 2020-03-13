package Step_Project_v2.helpers;

import Step_Project_v2.entity.Booking;
import Step_Project_v2.entity.Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Predicate;

public class Predicates {

  public static Predicate<Flight> isSomeHoursBefore(int hours) {
//    return f -> f.getDate().isBefore(LocalDate.now().plusDays(hours% 24 !=0 ? (hours/24+1): hours/24));
    return f-> (f.getDate().isEqual(LocalDate.now()) && f.getTime().isAfter(LocalTime.now()) ||
            (f.getDate().isEqual(LocalDate.now().plusDays(1)) && f.getTime().isBefore(LocalTime.now())));
  }

  public static Predicate<Flight> isBookable(String dest, LocalDate date, int numOfPeople) {
    return f -> f.getFreeSpaces() >= numOfPeople &&
            f.getDest().toLowerCase().equals(dest) && f.getDate().equals(date);
//            f.getDate().isBefore(date.plusDays(1)) && f.getDate().isAfter(date);
  }

  public static Predicate<Booking> isMyFlight(String name, String surname) {
    return b -> b.getPassengers().stream().anyMatch(p ->
            p.getName().toLowerCase().trim().equals(name) &&
                    p.getSurname().toLowerCase().trim().equals(surname));
  }
}

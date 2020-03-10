package Step_Project_11.base_classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

public class Flight {
  private int id;
  private String flightDest;
  private LocalDateTime flightDateTime;
  private int freeSpaces;

  // CONSTRUCTORS
  public Flight(int id, String flightDest, LocalDateTime flightDateTime, int freeSpaces) {
    this.id = id;
    this.flightDest = flightDest;
    this.flightDateTime = flightDateTime;
    this.freeSpaces = freeSpaces;
  }

  // OWN METHODS
  public static Flight parse(String line) {
    String[] chunks = line.split("\\|");
    throw new IllegalArgumentException("Not implemented yet...");
  }

  public String represent() {
    return String.format("%d|%s|%s|%d",
            id, flightDest, flightDateTime, freeSpaces);
  }

  // GETTERS - SETTERS
  public int getId() {
    return id;
  }

  public String getFlightDest() {
    return flightDest;
  }

  public LocalDateTime getFlightDateTime() {
    return flightDateTime;
  }

  public int getFreeSpaces() {
    return freeSpaces;
  }

  @Override
  public String toString() {
    return String.format("Flight[id=%d, flightDest='%s', flightDateTime=%s, freeSpaces=%d]",
            id, flightDest, flightDateTime, freeSpaces);
  }
}

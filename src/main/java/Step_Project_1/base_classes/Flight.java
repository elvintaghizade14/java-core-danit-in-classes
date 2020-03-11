package Step_Project_1.base_classes;

import java.time.LocalDateTime;

public class Flight {
  private int id;
  private String flightDest;
  private LocalDateTime flightDateTime;
  private int freeSpaces;

  public static int counter = 99;

  // CONSTRUCTORS
  public Flight(String flightDest, LocalDateTime flightDateTime, int freeSpaces) {
    this.id = ++counter;
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

  public void setId(int id) {
    this.id = id;
  }

  public void setFlightDest(String flightDest) {
    this.flightDest = flightDest;
  }

  public void setFlightDateTime(LocalDateTime flightDateTime) {
    this.flightDateTime = flightDateTime;
  }

  public void setFreeSpaces(int freeSpaces) {
    this.freeSpaces = freeSpaces;
  }

  @Override
  public String toString() {
    return String.format("Flight[id=%d, flightDest='%s', flightDateTime=%s, freeSpaces=%d]",
            id, flightDest, flightDateTime, freeSpaces);
  }
}

package Step_Project_1.base_classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Flight {
  private int id;
  private String flightDest;
  private LocalDate flightDate;
  private LocalTime flightTime;
  private int freeSpaces;
  private static int counter = 0;

  // CONSTRUCTORS
  public Flight(String flightDest, LocalDate flightDate, LocalTime flightTime, int freeSpaces) {
    this.id = ++counter;
    this.flightDest = flightDest;
    this.flightTime = flightTime;
    this.flightDate = flightDate;
    this.freeSpaces = freeSpaces;
  }

  // OWN METHODS
  public static Flight parse(String line) {
    String[] chunks = line.split("\\|");
    throw new IllegalArgumentException("Not implemented yet...");
  }

  public String represent() {
    return String.format("%d|%s|%s|%s|%d",
            id, flightDest, flightDate, flightTime, freeSpaces);
  }

  // GETTERS - SETTERS
  public int getId() {
    return id;
  }

  public String getFlightDest() {
    return flightDest;
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

  public void setFreeSpaces(int freeSpaces) {
    this.freeSpaces = freeSpaces;
  }

  public LocalDate getFlightDate() {
    return flightDate;
  }

  public void setFlightDate(LocalDate flightDate) {
    this.flightDate = flightDate;
  }

  public LocalTime getFlightTime() {
    return flightTime;
  }

  public void setFlightTime(LocalTime flightTime) {
    this.flightTime = flightTime;
  }

  @Override
  public String toString() {
    return String.format("Flight[id=%d, flightDest='%s', flightDate=%s, flightTime=%s, freeSpaces=%d]",
            id, flightDest, flightDate, flightTime, freeSpaces);
  }
}

package Step_Project_1.base_classes;

import java.util.List;

public class Booking {
  private int flightId;
  private List<User> passengers;

  // CONSTRUCTORS
  public Booking(int flightId, List<User> passengers) {
    this.flightId = flightId;
    this.passengers = passengers;
  }

  //OWN METHODS
  public static Booking parse(String line) {
    String[] chunks = line.split("\\|");
    throw new IllegalArgumentException("Not implemented yet...");
  }

  public String represent() {
    return String.format("%d|%s", flightId, passengers);
  }

  //GETTERS - SETTERS
  public int getFlightId() {
    return flightId;
  }

  public List<User> getPassengers() {
    return passengers;
  }

  public void setFlightId(int flightId) {
    this.flightId = flightId;
  }

  public void setPassengers(List<User> passengers) {
    this.passengers = passengers;
  }
}
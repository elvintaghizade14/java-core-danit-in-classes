package Step_Project_1.base_classes;

import java.util.List;
import java.util.UUID;

public class Booking {
  private int id;
  private int flightId;
  private List<Passenger> passengers;
  private static int counter = 0;

  // CONSTRUCTORS
  public Booking(int flightId, List<Passenger> passengers) {
    this.id = ++counter;
    this.flightId = flightId;
    this.passengers = passengers;
  }

  //OWN METHODS
  public static Booking parse(String line) {
    String[] chunks = line.split("\\|");
    throw new IllegalArgumentException("Not implemented yet...");
  }

  public String represent() {
    return String.format("%d|%d|%s", flightId, id, passengers);
  }

  //GETTERS - SETTERS
  public int getFlightId() {
    return flightId;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public void setFlightId(int flightId) {
    this.flightId = flightId;
  }

  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }
}
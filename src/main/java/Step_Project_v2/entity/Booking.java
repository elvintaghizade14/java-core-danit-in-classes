package Step_Project_v2.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Booking {
  private int id;
  private int flight_id;
  private List<Passenger> passengers;

  public static int counter = 0;

  public Booking(int flight_id, List<Passenger> passengers) {
    this.id = ++counter;
    this.flight_id = flight_id;
    this.passengers = passengers;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getFlight_id() {
    return flight_id;
  }

  public void setFlight_id(int flight_id) {
    this.flight_id = flight_id;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }

  public static String represent(Booking b) {
    return String.format("%d|%d|%s",
            b.id, b.flight_id, b.passengers.stream().map(Passenger::represent)
                    .collect(Collectors.toList()).toString());
  }
}

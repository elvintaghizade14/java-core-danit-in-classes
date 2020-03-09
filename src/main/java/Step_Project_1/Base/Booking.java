package Step_Project_1.Base;

import java.util.List;

public class Booking {
  private int flightID;
  private List<User> passengers;

  public Booking(int flightID, List<User> passengers) {
    this.flightID = flightID;
    this.passengers = passengers;
  }

  @Override
  public String toString() {
    return String.format("Booking[flightID=%d, passengers=%s]", flightID, passengers);
  }
}

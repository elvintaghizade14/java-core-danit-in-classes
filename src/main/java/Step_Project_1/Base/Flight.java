package Step_Project_1.Base;

import java.time.LocalDateTime;

public class Flight {
  private int ID;
  private String flightDest;
  private LocalDateTime flightDateTime;
  private int freeSpaces;

  public Flight(int ID, String flightDest, LocalDateTime flightDateTime, int freeSpaces) {
    this.ID = ID;
    this.flightDest = flightDest;
    this.flightDateTime = flightDateTime;
    this.freeSpaces = freeSpaces;
  }

  public String represent() {
    return String.format("%d:%s:%d", ID, flightDest, flightDateTime, freeSpaces);
  }

  @Override
  public String toString() {
    return String.format("Flight[ID=%d, flightDest='%s', flightDateTime=%s, freeSpaces=%d]",
            ID, flightDest, flightDateTime, freeSpaces);
  }

  public static Flight parse(String line) {
    String[] chunks = line.split("\\|");
    return new Flight(
            Integer.parseInt(chunks[0]),
            chunks[1],
            LocalDateTime.parse(chunks[2]),
            Integer.parseInt(chunks[3])
    );

  }


}

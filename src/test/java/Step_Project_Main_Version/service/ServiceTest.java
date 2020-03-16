package Step_Project_Main_Version.service;

import Step_Project_Main_Version.dao.DAOBookingFileText;
import Step_Project_Main_Version.dao.DAOFlightFileText;
import Step_Project_Main_Version.ex.BookingNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
  private DAOFlightFileText daoFlight = new DAOFlightFileText("flights.txt");
  private DAOBookingFileText daoBooking = new DAOBookingFileText("bookings.txt");
  private Service service;

  @BeforeEach
  public void setUp() {
    this.service = new Service(daoBooking, daoFlight);
  }

  @Test
  void showMenu() {
    String expected = "1. Online - board\n2. Show the flight info\n" +
            "3. Search and book a flight\n4. Cancel the booking\n5. My flights\n6. Exit";
    assertEquals(expected, service.showMenu());
  }

  @Test
  void getAllFlights() {
    String expected = "[1|Baku|2020-03-17|08:15:48|15, " +
            "2|Moscow|2020-03-17|09:58:32|15, " +
            "14|Baku|2020-03-17|13:06:55|85, " +
            "19|Moscow|2020-03-17|10:47:50|85, " +
            "25|Berlin|2020-03-17|12:43:22|5]";
    assertEquals(expected, service.getAllFlights().toString());
  }

  @Test
  void getFlightById() {
    String expected = "14|Baku|2020-03-17|13:06:55|85";
    assertEquals(expected, service.getFlightById(14));
  }

  @Test
  void searchForBook() {
  }

  @Test
  void book() {
    String expected = "[4|Moscow|2020-03-18|13:53:18|75]";
    assertEquals(expected, service.searchForBook("moscow",
            LocalDate.parse("2020-03-18"), 1).toString());
  }
}
package Step_Project_1.services;

import Step_Project_1.Base.Booking;
import Step_Project_1.Base.Flight;
import Step_Project_1.Base.User;
import Step_Project_1.DAO.DAO;
import Step_Project_1.DAO.DAOBookingFile;
import Step_Project_1.DAO.DAOFlightFile;
import Step_Project_1.DAO.DAOUserFile;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

  DAO<Flight> flightDAO = new DAOFlightFile();
  DAO<User> userDAO = new DAOUserFile();
  DAO<Booking> bookingDAO = new DAOBookingFile();

  public String getMenuContents() {
    StringBuilder sb = new StringBuilder();
    return sb.append("1. Online - board\n")
            .append("2. Show the flight info\n")
            .append("3. Search and book a flight\n")
            .append("4. Cancel the booking\n")
            .append("5. My flights\n")
            .append("6. Exit")
            .toString();
  }

  public List<String> getAllInfoForOnlineBoard() {
    return flightDAO.getAll().stream().map(Flight::represent).collect(Collectors.toList());
  }
}

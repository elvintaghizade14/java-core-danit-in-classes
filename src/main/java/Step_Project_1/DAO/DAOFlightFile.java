package Step_Project_1.DAO;

import Step_Project_1.Base.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOFlightFile implements DAO<Flight> {

  private File file;

  public DAOFlightFile(String filename) {
    this.file = new File(filename);
  }

  @Override
  public Optional<Flight> get(int id) {
    return Optional.empty();
  }

  @Override
  public Collection<Flight> getAll() {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      return br.lines().map(Flight::parse).collect(Collectors.toList());
    } catch (IOException ex) {
      return new ArrayList<>();
    }
  }

  @Override
  public Collection<Flight> getAllBy(Predicate<Flight> p) {
    return null;
  }

  @Override
  public void create(Flight data) {

  }

  @Override
  public void delete(int id) {
    Collection<Flight> flights = getAllBy(f -> f. != id);
    write(students);
  }

  private void write(Collection<Flight> flights) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
      for (Flight f: flights) {
        bw.write(f.represent());
        bw.write("\n");
      }
    } catch (IOException ex) {
      throw new RuntimeException("DAO:Flight:File:write:IOException", ex);
    }
  }
}

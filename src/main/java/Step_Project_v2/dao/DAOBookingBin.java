package Step_Project_v2.dao;

import Step_Project_v2.entity.Booking;
import Step_Project_v2.entity.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOBookingBin implements DAO<Booking> {

  private File file;

  public DAOBookingBin(String filename) {
    this.file = new File(filename);
  }

  private void write(Collection<Booking> bookings) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      oos.writeObject(bookings);
    } catch (IOException ex) {
      throw new RuntimeException("DAO:write:IOException", ex);
    }
  }

  @Override
  public Optional<Booking> get(int id) {
    return getAll().stream().filter(b -> b.getId() == id).findFirst();
  }

  @Override
  public Collection<Booking> getAll() {
    try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      Object readed = ois.readObject();
      return (List<Booking>) readed;
    } catch (IOException | ClassNotFoundException ex) {
      return new ArrayList<>();
    }
  }

  @Override
  public Collection<Booking> getAllBy(Predicate<Booking> b) {
    return getAll().stream().filter(b).collect(Collectors.toList());
  }

  @Override
  public void create(Booking booking) {
    Collection<Booking> bookings = getAll();
    bookings.add(booking);
    write(bookings);
  }

  @Override
  public void delete(int id) {
    Collection<Booking> bookings = getAllBy(b -> b.getId() != id);
    write(bookings);
  }
}

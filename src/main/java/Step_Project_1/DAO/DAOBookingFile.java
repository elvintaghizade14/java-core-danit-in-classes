package Step_Project_1.DAO;

import Step_Project_1.Base.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOBookingFile implements DAO<Booking> {

  @Override
  public Optional<Booking> get(int id) {
    return Optional.empty();
  }

  @Override
  public Collection<Booking> getAll() {
    return null;
  }

  @Override
  public Collection<Booking> getAllBy(Predicate<Booking> p) {
    return null;
  }

  @Override
  public void create(Booking data) {

  }

  @Override
  public void delete(int id) {

  }
}

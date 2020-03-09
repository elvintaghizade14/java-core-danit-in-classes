package Step_Project_1.DAO;

import Step_Project_1.Base.User;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class DAOUserFile implements DAO<User> {

  @Override
  public Optional<User> get(int id) {
    return Optional.empty();
  }

  @Override
  public Collection<User> getAll() {
    return null;
  }

  @Override
  public Collection<User> getAllBy(Predicate<User> p) {
    return null;
  }

  @Override
  public void create(User data) {

  }

  @Override
  public void delete(int id) {

  }
}

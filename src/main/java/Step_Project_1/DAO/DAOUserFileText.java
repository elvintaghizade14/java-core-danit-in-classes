package Step_Project_1.DAO;

import Step_Project_1.base_classes.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOUserFileText implements DAO<User> {

  private File file;

  public DAOUserFileText(String filename) {
    this.file = new File(filename);
  }

  private void write(Collection<User> users) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
      for (User s : users) {
        bw.write(s.represent());
        bw.write("\n");
      }
    } catch (IOException ex) {
      throw new RuntimeException("DAO-User:write:IOException", ex);
    }
  }

  @Override
  public Optional<User> get(int id) {
    return getAll().stream().filter(u -> u.getId() == id).findFirst();
  }

  @Override
  public Collection<User> getAll() {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      return br.lines().map(User::parse).collect(Collectors.toList());
    } catch (IOException ex) {
      return new ArrayList<>();
    }
  }

  @Override
  public Collection<User> getAllBy(Predicate<User> p) {
    return getAll().stream().filter(p).collect(Collectors.toList());
  }

  @Override
  public void create(User user) {
    Collection<User> users = getAll();
    users.add(user);
    write(users);
  }

  @Override
  public void delete(int id) {
    Collection<User> users = getAllBy(s -> s.getId() != id);
    write(users);
  }
}

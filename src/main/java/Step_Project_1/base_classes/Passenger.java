package Step_Project_1.base_classes;

public class Passenger {
  private String name;
  private String surname;

  // CONSTRUCTORS
  public Passenger(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  // OWN METHODS
  public static Passenger parse(String line) {
    String[] chunks = line.split("\\|");
    return new Passenger(chunks[1], chunks[2]);
  }

  public String represent() {
    return String.format("%s|%s", name, surname);
  }

  // GETTERS - SETTERS
  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
  public String toString() {
    return String.format("Passenger[name='%s', surname='%s']", name, surname);
  }
}
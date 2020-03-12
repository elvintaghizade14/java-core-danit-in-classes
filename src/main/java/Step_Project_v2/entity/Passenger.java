package Step_Project_v2.entity;

public class Passenger{
  private String name;
  private String surname;

  public Passenger(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public static String represent(Passenger p) {
    return String.format("%s|%s", p.name, p.surname);
  }
}

package Step_Project_11.base_classes;

public class User {
  private int id;
  private String name;
  private String surname;
  private String gender;
  private int age;

  private static int counter = 0;

  // CONSTRUCTORS
  public User(String name, String surname, String gender, int age) {
    this.id = ++counter;
    this.name = name;
    this.surname = surname;
    this.gender = gender;
    this.age = age;
  }

  public User(int id, String name, String surname, String gender, int age) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.gender = gender;
    this.age = age;
  }

  // OWN METHODS
  public static User parse(String line) {
    String[] chunks = line.split("\\|");
    return new User(
            Integer.parseInt(chunks[0]),
            chunks[1],
            chunks[2],
            chunks[3],
            Integer.parseInt(chunks[4])
    );
  }

  public String represent() {
    return String.format("%d|%s|%s|%s|%d", id, name, surname, gender, age);
  }

  // GETTERS - SETTERS
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getGender() {
    return gender;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return String.format("User[id=%d, name='%s', surname='%s', gender='%s', age=%d]",
            id, name, surname, gender, age);
  }
}
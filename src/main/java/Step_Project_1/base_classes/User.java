package Step_Project_1.base_classes;

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

  public User(String name, String surname) {
    this.id = ++counter;
    this.name = name;
    this.surname = surname;
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

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static int getCounter() {
    return counter;
  }

  public static void setCounter(int counter) {
    User.counter = counter;
  }

  @Override
  public String toString() {
    return String.format("User[id=%d, name='%s', surname='%s', gender='%s', age=%d]",
            id, name, surname, gender, age);
  }
}
package Step_Project_1.Base;

public class User {
  private int ID;
  private String name;
  private String surname;
  private String gender;
  private int age;

  public User(int id, String name, String surname, String gender, int age) {
    this.ID = id;
    this.name = name;
    this.surname = surname;
    this.gender = gender;
    this.age = age;
  }

  @Override
  public String toString() {
    return String.format("User[ID=%d, name='%s', surname='%s', gender='%s', age=%d]", ID, name, surname, gender, age);
  }
}

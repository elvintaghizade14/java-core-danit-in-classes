package module_03.lesson_36;

import java.sql.*;

public class SQLApp {
  private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
  private final static String UNAME = "postgres";
  private final static String PWD = "admin123";

  public static void main(String[] args) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, UNAME, PWD);
    String SQL = "select * from employees order by id desc";
    PreparedStatement stmt = conn.prepareStatement(SQL);
    ResultSet resultSet = stmt.executeQuery();
    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      int age = resultSet.getInt("age");

      System.out.printf("%5d %5s %5s %5d%n", id, name, email, age);
    }
  }
}
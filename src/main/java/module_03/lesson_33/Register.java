package module_03.lesson_33;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Register {
  private final Path path = Paths.get("content_login", "users.txt");

  private void write(String name, String email, String pass, String re_pass) throws IOException {
    File file = new File(String.valueOf(path));
    FileWriter fw = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(String.format("%s::::%s::::%s::::%s\n", name, email, pass, re_pass));
    bw.close();
  }

  public boolean register(String name, String email, String pass, String re_pass) throws IOException {
    if (!pass.equals(re_pass)) return false;
    write(name, email, pass, re_pass);
    return true;
  }

}
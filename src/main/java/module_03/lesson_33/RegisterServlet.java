package module_03.lesson_33;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RegisterServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (OutputStream os = resp.getOutputStream()) {
      Files.copy(Paths.get("content_login", "register.html"), os);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String name = req.getParameter("name");
    String email = req.getParameter("email");
    String pass = req.getParameter("pass");
    String re_pass = req.getParameter("re_pass");

    Register reg = new Register();

    boolean result = reg.register(name, email, pass, re_pass);

    try (OutputStream os = resp.getOutputStream()) {
      Files.copy(Paths.get("content_login", result ? "successful.html" : "unsuccessful.html"), os);
    }

  }

}

package module_03.lesson_33;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class RedirectServlet extends HttpServlet {
  private final String redirectTo;


  public RedirectServlet(String redirectTo) {
    this.redirectTo = redirectTo;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (OutputStream os = resp.getOutputStream()) {
      resp.sendRedirect(redirectTo);
    }
  }
}

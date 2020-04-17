package module_03.lesson_32.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class InfoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (PrintWriter pw = resp.getWriter()) {
      pw.write("Hello, World!");
    }
//    try (OutputStream os = resp.getOutputStream()) {
//      os.write("Hello, World!");
//    }
  }
}

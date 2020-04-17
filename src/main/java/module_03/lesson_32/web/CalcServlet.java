package module_03.lesson_32.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String xs = req.getParameter("x");
    String ys = req.getParameter("y");
    String ops = req.getParameter("op");

    Calculator calc = new Calculator();

    String result = calc.doOperation(xs, ys, ops);

    try (PrintWriter pw = resp.getWriter()) {
      pw.write(result);
    }

  }

}

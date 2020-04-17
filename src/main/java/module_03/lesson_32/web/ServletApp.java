package module_03.lesson_32.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletApp {
  public static void main(String[] args) throws Exception {
    new Server(8080) {{
      setHandler(new ServletContextHandler() {{
        addServlet(new ServletHolder(new HttpServlet() {
          @Override
          protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            try (PrintWriter w = resp.getWriter()) {
              w.write("Hello, World!");
            }
          }
        }), "/*");
      }});
      start();
      join();
    }};
  }
}

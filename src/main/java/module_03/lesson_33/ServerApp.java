package module_03.lesson_33;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(new ServletHolder(new HomePageServlet()), "/index/*");
    handler.addServlet(new ServletHolder(new LoginServlet()), "/login/*");
    handler.addServlet(new ServletHolder(new RegisterServlet()), "/register/*");
    handler.addServlet(new ServletHolder(new RedirectServlet("/login")), "");
    handler.addServlet(new ServletHolder(new StaticServlet("images")), "/images/*");
    handler.addServlet(new ServletHolder(new StaticServlet("js")), "/js/*");
    handler.addServlet(new ServletHolder(new StaticServlet("css")), "/css/*");
    handler.addServlet(new ServletHolder(new StaticServlet("font")), "/font/*");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}

package space.harbour.l121.servlets;

import space.harbour.l121.servlets.frontend.FrontendServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;

/**
 * @author v.chibrikov
 */
public class SimpleMain {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8090);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        Servlet frontend = new FrontendServlet();
        context.addServlet(new ServletHolder(frontend), "/*");

        server.setHandler(context);

        server.start();
        server.join();
        System.out.println("Finished");
    }
}

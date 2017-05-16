package space.harbour.l121.servlets;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import space.harbour.l121.servlets.frontend.FrontendServlet;

import javax.servlet.Servlet;

/**
 * @author v.chibrikov
 */
public class ResourceMain {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8090);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        Servlet frontend = new FrontendServlet();
        context.addServlet(new ServletHolder(frontend), "/*");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
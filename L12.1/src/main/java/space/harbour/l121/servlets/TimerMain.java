package space.harbour.l121.servlets;

import org.eclipse.jetty.server.Server;
import space.harbour.l121.servlets.frontend.TimeServlet;

public class TimerMain {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8090);
        server.setHandler(new TimeServlet());

        server.start();
        server.join();
    }
}


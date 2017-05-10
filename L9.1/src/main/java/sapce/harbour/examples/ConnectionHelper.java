package sapce.harbour.examples;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            String url =
                    "jdbc:mysql://" +            //db type
                    "localhost:" +               //host name
                    "3306/" +                    //port
                    "db_example?" +              //db name
                    "user=tully&" +              //login
                    "password=tully";            //password

            return DriverManager.getConnection(url);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void example() {
        try (Connection connection = getConnection()) {
            System.out.println("Connected to: " + connection.getMetaData().getURL());
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

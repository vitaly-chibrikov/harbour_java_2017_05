package space.harbour.l151;

import com.sun.management.GarbageCollectionNotificationInfo;
import space.harbour.l151.annotations.AddLog;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Created by tully.
 */
//VM options -Xmx512m -Xms512m
//VM options -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=4000, suspend=n
//VM options  -javaagent:target/agent.jar
//VM options  -XX:+UseSerialGC

public class Main {

    @AddLog(message = "Starting the the application")
    public static void main(String... args) throws Exception {

        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 10_000_000;
        Object[] array = new Object[size];
        System.out.println("Array of size: " + array.length + " created");
        Thread.sleep(10 * 1000);

        reFillArray(array);

    }

    //@AddLog(message = "Starting the loop")
    private static void reFillArray(Object[] array) throws InterruptedException {
        int size = array.length;
        int n = 0;
        while (n < Integer.MAX_VALUE) {
            int i = n % size;
            array[i] = new String(""); //no String pool
            n++;
            if (n % 1024 == 0) {
                Thread.sleep(1);
            }
            if (n % size == 0) {
                logs(n);
                array = new Object[size];
            }
        }
    }

    private static void logs(int n) {
        System.out.println("Created " + n + " objects");
    }


    static class InnerClass {
        String a = "Hello Java";
    }
}

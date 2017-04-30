package space.harbour.l21;

import java.lang.management.ManagementFactory;

/**
 * Created by tully.
 * <p>
 * VM options: -Xmx512m -Xms512m
 */

public class Main {
    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        //each class in Java extends Object
        //for each runtime object has special object with class java.lang.Class
        //object of java.lang.Class contains information about the object

        //how to monitor heap memory in jconsole?
        //array of strings with string pool and without it
        
        infiniteLoop();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private static void infiniteLoop() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

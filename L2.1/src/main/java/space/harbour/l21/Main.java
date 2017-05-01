package space.harbour.l21;

import java.lang.management.ManagementFactory;

/**
 * Created by tully.
 * <p>
 * VM options: -Xmx64m -Xms64m
 */

public class Main {
    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        // autoboxing and unboxing
        // each class in Java extends Object
        // overloading of hashCode and equals
        // equals vs ==
        // int[] is an object

        // each runtime object has a special object of the class java.lang.Class
        // object of java.lang.Class contains information about the object

        // * how to monitor heap memory in jconsole?
        // * strings with string pool and without it


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

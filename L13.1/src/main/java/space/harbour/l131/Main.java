package space.harbour.l131;

import space.harbour.l131.interference.Interference;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //RandomRun.example();
        //simple();


        SeriesRunExample.example();
        //new Interference().example();
    }

    private static void simple() throws InterruptedException {
        //get an object ot the main thread
        Thread t = Thread.currentThread();
        t.setName("my main");
        System.out.println(t.getId() + " " + t.getName());
        t.setPriority(10);
        //get priority of the main thread
        System.out.println(t.getPriority());


        //create new thread with runnable lambda
        long start = System.nanoTime();
        Thread t2 = new Thread(() -> {
            long finish = System.nanoTime();
            System.out.println("Spent: " + (finish - start));
        });
        //t2.setDaemon(true);
        t2.start();

        t2.join();

        System.out.println("Main");

        //get thread status
        System.out.println("main: " + t.getState());

        //set daemon

        //join to a new thread

        //calculate ns between start and run
    }
}

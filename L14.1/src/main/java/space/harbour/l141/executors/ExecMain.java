package space.harbour.l141.executors;

import java.util.concurrent.*;

/**
 * Created by tully.
 */
public class ExecMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        futureExample();
        schedulingExample();
    }

    private static void schedulingExample() {
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        Runnable job = () -> System.out.println("Message from a thread");
        pool.schedule(job, 10, TimeUnit.SECONDS);
        pool.shutdown();
    }

    private static void futureExample() throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Callable<Integer> callable = () -> 42;
        Future<Integer> future = pool.submit(callable);
        int result = future.get(); //this method is blocking
        System.out.println("Result from the new thread: " + result);
        pool.shutdown();
    }
}

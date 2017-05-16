package space.harbour.l131.interference;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tully.
 */
public class CounterSemaphore {
    public static final int HUNDRED_MILLION = 100_000_000;

    private final AtomicInteger count = new AtomicInteger();
    private final static CounterSemaphore instance = new CounterSemaphore();

    private CounterSemaphore() {

    }

    public static CounterSemaphore instance() {
        return instance;
    }

    public boolean isIncrementAndCheck() {
        return count.incrementAndGet() < HUNDRED_MILLION;
    }

}

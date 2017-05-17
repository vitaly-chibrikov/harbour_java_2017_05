package space.harbour.l131.interference;

public final class InterferenceThread extends Thread {
    private static volatile int i;
    private static final Object lock = new Object();

    public void run() {
        while (CounterSemaphore.instance().isIncrementAndCheck()) {
            increment();
        }
    }

    private void increment() {
        synchronized (lock) {
            i++;
        }
    }

    int getI() {
        return i;
    }
}

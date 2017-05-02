package space.harbour.l31.collections;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Created by tully.
 */

// Collections
// Arrays
// Collections2
// Lists
// Sets
// CollectionUtils

public class Main {
    private static final int MEASURE_COUNT = 100;

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static void main(String... args) {
        Collection<Integer> example = new TreeSet<>();
        int min = 0;
        int max = 9_999_999;
        for (int i = min; i < max + 1; i++) {
            example.add(i);
        }


        calcTime(() -> example.contains(max));
    }

    private static void calcTime(Runnable runnable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++)
            runnable.run();
        long finishTime = System.nanoTime();
        long timeNs = (finishTime - startTime) / MEASURE_COUNT;
        System.out.println("Time spent: " + timeNs + "ns (" + timeNs / 1_000_000 + "ms)");
    }
}

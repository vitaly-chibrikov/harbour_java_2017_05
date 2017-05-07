package space.harbour.l61.strategy;

import java.util.List;

/**
 * Created by tully.
 */
public class HeapSort<T> implements Algorithm<T> {
    @Override
    public void sort(List<T> list) {
        System.out.println("Heap sort");
    }
}

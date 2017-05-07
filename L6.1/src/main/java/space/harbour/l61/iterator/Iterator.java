package space.harbour.l61.iterator;

/**
 * Created by tully.
 *
 * Traversal abstraction in the Iterator pattern.
 *
 */
public interface Iterator<T> {
    T next();
    boolean hasNext();
}

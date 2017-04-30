package space.harbour.l31.collections;

import java.util.*;

/**
 * Created by tully.
 * <p>
 * Common cases:
 * <p>
 * {@link #setToArrayList(Set) Set to ArrayList},
 * <p>
 * {@link #listToHashSet(List) List to HashSet},
 * <p>
 * {@link #listToArray(List) List to Array},
 * <p>
 * {@link #setToArray(Set) Set to Array},
 * <p>
 * {@link #singletonList(Object) List with one element},
 * <p>
 * {@link #singletonSet(Object) Set with one element},
 * <p>
 * {@link #listFromArray(Object[]) List from array},
 * <p>
 * {@link #immutable(Collection) Immutable collection}
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class CollectionHelper {

    private CollectionHelper(){}

    /**
     * Creates ArrayList on base of the Set.
     * @param set sourse
     * @return List with elements of the same type as the set.
     */

    public static List<Object> setToArrayList(Set<?> set) {
        return new ArrayList<>(set);
    }

    public static Set<Object> listToHashSet(List<?> list) {
        return new HashSet<>(list);
    }

    public static Object[] listToArray(List<?> list) {
        return list.toArray(new Object[list.size()]);
    }

    public static Object[] setToArray(Set<?> set) {
        return set.toArray(new Object[set.size()]);
    }

    public static List<Object> singletonList(Object object) {
        return Collections.singletonList(object);
    }

    public static Set<Object> singletonSet(Object object) {
        return Collections.singleton(object);
    }

    public static List<Object> listFromArray(Object[] array) {
        //return new ArrayList<Object>(array);
        return Arrays.asList(array);
    }

    public static Collection<Object> immutable(Collection<?> collection) {
        return Collections.unmodifiableCollection(collection);
    }
}

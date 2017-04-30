package space.harbour.l31.generics;

import java.util.Objects;

/**
 * Created by tully.
 */
public class GenericClassExample<T> {
    public T value;

    public GenericClassExample() {
        this.value = null;
    }

    public GenericClassExample(T value) {
        this.value = value;
    }

    public T getT() {
        return value;
    }

    public static void main(String[] args) {
        GenericClassExample<Integer> intObject = new GenericClassExample<>(1);
        Integer valueInteger = intObject.getT();

        //GenericClassExample<String> stringObject = new GenericClassExample<>("word");
        //String valueString = stringObject.getT();
    }
}

package space.harbour.l31.generics;

/**
 * Created by tully.
 */
public class GenericClassExample<Type> {
    public Type value;

    public GenericClassExample() {
        this.value = null;
    }

    public GenericClassExample(Type value) {
        this.value = value;
    }

    public Type getT() {
        return value;
    }
    public static void main(String[] args) {
        GenericClassExample<Integer> intObject = new GenericClassExample<>(1);
        Integer valueInteger = intObject.getT();

        GenericClassExample<String> stringObject = new GenericClassExample<>("word");
        String valueString = stringObject.getT();
    }
}

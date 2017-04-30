package space.harbour.l31.generics;

import space.harbour.l31.generics.NumberClassExample;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
        //instantiate an object of generic type
        //show how generics can help to find error in compile time
        //try to get generic type in runtime from class and from an object
    }


    private static void printTypeFromClass(Class<? extends GenericClassExample> clazz) throws IllegalAccessException, NoSuchFieldException {
        System.out.println(clazz
                .getDeclaredField("value")
                .getType()
        );
    }

    private static void printTypeFromObject(GenericClassExample genericClassExample) throws IllegalAccessException, NoSuchFieldException {
        System.out.println(genericClassExample.getClass()
                .getDeclaredField("value")
                .get(genericClassExample)
                .getClass()
                .getCanonicalName()
        );
    }

}

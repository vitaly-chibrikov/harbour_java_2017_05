package space.harbour.l31.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tully.
 */
public class UpperBoundExample<T extends Number> {

    public static void main(String[] args) {
        List<? extends Number> list;

        list = new ArrayList<Number>();
        list = new ArrayList<Integer>();
        list = new ArrayList<Double>();

        //list = new ArrayList<Character>();
        //list = new ArrayList<String>();
        //list = new ArrayList<Object>();

        doSomething(list);
    }

    private static void doSomething(List<? extends Number> list) {
        //list.add(1);// error

        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
    }
}

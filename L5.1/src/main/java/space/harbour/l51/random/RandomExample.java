package space.harbour.l51.random;

import java.util.Random;

/**
 * Created by tully.
 */
public class RandomExample {
    public static void main(String... args) {
        Random rnd0 = new Random();
        System.out.println("For random seed");
        System.out.println("Next int: " + rnd0.nextInt());
        System.out.println("Next int to 100: " + rnd0.nextInt(100));
        System.out.println();

        Random rnd1 = new Random(0);
        System.out.println("For seed: 0");
        System.out.println("Next int: " + rnd1.nextInt());
        System.out.println("Next int to 100: " + rnd1.nextInt(100));
        System.out.println();

        System.out.println("Math.random(): " + Math.random());
    }
}

package space.harbour.l71.structural.composite;

/**
 * Created by tully.
 *
 * Leaf in the Composite pattern.
 */
public class Soldier implements Unit {
    @Override
    public void move() {
        System.out.println("Yes sir!");
    }

    @Override
    public void attack() {
        System.out.println("Attacking!");
    }

    @Override
    public void hold() {
        System.out.println("Stated to dig");
    }
}

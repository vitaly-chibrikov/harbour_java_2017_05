package space.harbour.l71.structural.adapter;

/**
 * Created by tully.
 *
 * Client in the Adapter pattern.
 */
public class Main {
    public static void main(String[] args) {
        Polar adapter = new Polar2CartesianAdapter(new CartesianPoint());

        adapter.setPoint(0, 42);
        adapter.setPoint(1, Math.PI / 2);
        adapter.setPoint(2, Math.PI);
    }
}

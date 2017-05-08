package space.harbour.l71.structural.proxy;

/**
 * Created by tully.
 * <p>
 * Proxy for the subject.
 */
public class Proxy implements Subject {
    private final Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void doIt() {
        System.out.println("doIt() call logged");
        subject.doIt();
    }
}

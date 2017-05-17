package space.harbour.l141.counter;

/**
 * @author v.chibrikov
 */
public class CallCounter {

    //use AtomicInteger for the example
    private int count = 0;

    public void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}

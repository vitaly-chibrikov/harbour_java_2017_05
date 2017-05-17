package space.harbour.l141;

import space.harbour.l141.messageSystem.Address;
import space.harbour.l141.messageSystem.Addressee;
import space.harbour.l141.messageSystem.MessageSystem;

/**
 * Created by tully.
 */
public class DBService extends Thread implements Addressee {
    private final AddressContext context;
    private final Address address;

    public DBService(AddressContext context) {
        this.context = context;
        this.address = new Address();
        context.addAddress("DBService", this.getAddress());
        MessageSystem.instance().addAddressee(this);
    }

    @Override
    public Address getAddress() {
        return address;
    }

    public int getUserId(String name) {
        //load id from name
        return name.hashCode();
    }

    public void run() {
        while (true) {
            MessageSystem.instance().exec(this);
            try {
                Thread.sleep(MessageSystem.STEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

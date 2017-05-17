package space.harbour.l141;

import space.harbour.l141.messageSystem.Address;
import space.harbour.l141.messageSystem.Addressee;
import space.harbour.l141.messageSystem.MessageSystem;
import space.harbour.l141.messages.MsgGetUserId;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tully.
 */
public class FrontendService extends Thread implements Addressee {
    private final AddressContext context;
    private final Address address;

    private final Map<Integer, String> users = new HashMap<>();

    public FrontendService(AddressContext context) {
        this.context = context;
        this.address = new Address();
        context.addAddress("FrontendService", this.getAddress());
        MessageSystem.instance().addAddressee(this);
    }

    @Override
    public Address getAddress() {
        return address;
    }

    public void handleRequest(String login) {
        MessageSystem.instance().sendMessage(new MsgGetUserId(getAddress(), context.get("DBService"),  login));
    }

    public void addUser(int id, String name) {
        users.put(id, name);
        System.out.println("User: " + name + " has id: " + id);
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

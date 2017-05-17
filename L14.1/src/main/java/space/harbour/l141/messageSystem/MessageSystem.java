package space.harbour.l141.messageSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author tully
 */
public final class MessageSystem {
    public static final int STEP_TIME = 10;

    private final Map<Address, ConcurrentLinkedQueue<Message>> messages = new HashMap<>();
    private final static MessageSystem instance = new MessageSystem();

    public static MessageSystem instance() {
        return instance;
    }

    private MessageSystem() {
    }

    public void addAddressee(Addressee addressee) {
        messages.put(addressee.getAddress(), new ConcurrentLinkedQueue<>());
    }

    public void sendMessage(Message message) {
        messages.get(message.getTo()).add(message);
    }

    public void exec(Addressee addressee) {
        ConcurrentLinkedQueue<Message> queue = messages.get(addressee.getAddress());
        while (!queue.isEmpty()) {
            Message message = queue.poll();
            message.exec(addressee);
        }
    }
}

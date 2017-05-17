package space.harbour.l141.messages;

import space.harbour.l141.DBService;
import space.harbour.l141.messageSystem.Address;
import space.harbour.l141.messageSystem.Addressee;
import space.harbour.l141.messageSystem.Message;

/**
 * Created by tully.
 */
public abstract class MsgToDB extends Message {
    public MsgToDB(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec(Addressee addressee) {
        if (addressee instanceof DBService) {
            exec((DBService) addressee);
        }
    }

    public abstract void exec(DBService dbService);
}

package space.harbour.l141.messages;

import space.harbour.l141.FrontendService;
import space.harbour.l141.messageSystem.Address;
import space.harbour.l141.messageSystem.Addressee;
import space.harbour.l141.messageSystem.Message;

/**
 * Created by tully.
 */
public abstract class MsgToFrontend extends Message {
    public MsgToFrontend(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec(Addressee addressee) {
        if (addressee instanceof FrontendService) {
            exec((FrontendService) addressee);
        }
    }

    public abstract void exec(FrontendService frontendService);
}
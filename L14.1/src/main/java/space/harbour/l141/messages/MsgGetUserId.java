package space.harbour.l141.messages;

import space.harbour.l141.DBService;
import space.harbour.l141.messageSystem.Address;
import space.harbour.l141.messageSystem.MessageSystem;

/**
 * Created by tully.
 */
public class MsgGetUserId extends MsgToDB {
    private final String login;

    public MsgGetUserId(Address from, Address to, String login) {
        super(from, to);
        this.login = login;
    }

    @Override
    public void exec(DBService dbService) {
        int id = dbService.getUserId(login);
        MessageSystem.instance().sendMessage(new MsgGetUserIdAnswer(getTo(), getFrom(), login, id));
    }
}

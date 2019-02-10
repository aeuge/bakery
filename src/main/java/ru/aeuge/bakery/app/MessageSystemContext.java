package ru.aeuge.bakery.app;

import lombok.Data;
import ru.aeuge.bakery.messagesystem.Address;
import ru.aeuge.bakery.messagesystem.MessageSystem;

@Data
public class MessageSystemContext {
    private final MessageSystem messageSystem;

    private Address frontAddress;
    private Address dbAddress;

    public MessageSystemContext(MessageSystem messageSystem) {
        this.messageSystem = messageSystem;
    }
}

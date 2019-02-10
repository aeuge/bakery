package ru.aeuge.bakery.app;

import ru.aeuge.bakery.messagesystem.Address;
import ru.aeuge.bakery.messagesystem.Addressee;
import ru.aeuge.bakery.messagesystem.Message;

public abstract class MessageToFrontend extends Message {
    public MessageToFrontend(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec(Addressee addressee) {
        if (addressee instanceof MessageWebSocket) {
            exec((MessageWebSocket) addressee);
        }
    }

    public abstract void exec(MessageWebSocket messageWebSocket);
}
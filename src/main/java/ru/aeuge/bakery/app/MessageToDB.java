package ru.aeuge.bakery.app;

import ru.aeuge.bakery.messagesystem.Address;
import ru.aeuge.bakery.messagesystem.Addressee;
import ru.aeuge.bakery.messagesystem.Message;

public abstract class MessageToDB extends Message {
    public MessageToDB(Address from, Address to) {
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

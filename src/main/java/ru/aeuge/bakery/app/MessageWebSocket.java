package ru.aeuge.bakery.app;

import ru.aeuge.bakery.messagesystem.Addressee;

import javax.websocket.Session;

public interface MessageWebSocket extends Addressee {
    Session getSession();
}

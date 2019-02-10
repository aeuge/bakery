package ru.aeuge.bakery.servlet.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.aeuge.bakery.app.MessageSystemContext;
import ru.aeuge.bakery.app.MessageWebSocket;
import ru.aeuge.bakery.app.messages.MessageDB;
import ru.aeuge.bakery.messagesystem.Address;
import ru.aeuge.bakery.messagesystem.Message;
import ru.aeuge.bakery.messagesystem.MessageSystem;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@ServerEndpoint("/message")
public class MessageWebSocketImpl implements MessageWebSocket {
    private Address address;
    private Queue<MessageWebSocketImpl> users = new ConcurrentLinkedQueue<>();
    private Session session;

    @Autowired
    private MessageSystemContext context;

    public MessageWebSocketImpl() {
        address = new Address();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("mws created");
        context.getMessageSystem().addAddressee(this);
    }

    @OnMessage
    public void onMessage(String data) {
        try {
            Message message = new MessageDB(getAddress(),context.getDbAddress(),data);
            context.getMessageSystem().sendMessage(message);
            System.out.println("Sending messageWS to DB: " + data);
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        users.add(this);
        setSession(session);
        System.out.println("onOpen");
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @OnClose
    public void onClose() {
        users.remove(this);
        context.getMessageSystem().endThread(this);
        System.out.println("onClose");
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public MessageSystem getMS() {
        return context.getMessageSystem();
    }
}

package ru.aeuge.bakery.app;

import ru.aeuge.bakery.dataset.DataSet;
import ru.aeuge.bakery.messagesystem.Addressee;
import ru.aeuge.bakery.messagesystem.MessageSystem;

import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable, Addressee {
    String getLocalStatus();

    <T extends DataSet> void save(T dataset);

    <T extends DataSet> T read(long id, Class<T> clazz) throws SQLException;

    <T extends DataSet> T readByName(String name, Class<T> clazz);

    <T extends DataSet> List<T> readAll(Class<T> clazz);

    int getCacheCount();

    MessageSystem getMS();
}

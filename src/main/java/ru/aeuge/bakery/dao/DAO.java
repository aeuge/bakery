package ru.aeuge.bakery.dao;

import ru.aeuge.bakery.dataset.DataSet;

import java.util.List;

public interface DAO {
     <T extends DataSet> void save(T dataSet);

     <T extends DataSet> T read(long id, Class<T> clazz);

     <T extends DataSet> T  readByName(String name, Class<T> clazz);

     <T extends DataSet> List<T> readAll(Class<T> clazz);
}

package ru.aeuge.bakery.DBservice.db;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import ru.aeuge.bakery.app.DBService;
import ru.aeuge.bakery.dataset.Users;

@Component
public class DBDataInitializer {
    public DBDataInitializer(DBService dbService) {
        try {
            Users user = new Users("admin", DigestUtils.md5DigestAsHex("admin".getBytes()),100);
            dbService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

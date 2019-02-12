package ru.aeuge.bakery.dataset;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class Users extends DataSet {
    private String login;
    private String password;//md5+salt
    private String name;
    private String nameOfficial;
    private String deliveryPoint;
    private String address;
    private String addressOfficial;
    private String nameShort;
    private String KPP;
    private String Phone;
    private String Comment;
    private Integer order = 0;
    private Integer accessLevel=0;

    public Users(String name, String password, Integer accessLevel) {
        this.name = name;
        this.password = password;
        this.accessLevel = accessLevel;
    }
}

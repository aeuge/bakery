package ru.aeuge.bakery.dataset;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class Ingridient extends DataSet {
    private String name;
    private Long cost = Long.valueOf(0);
}

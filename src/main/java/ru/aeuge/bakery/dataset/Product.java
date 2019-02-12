package ru.aeuge.bakery.dataset;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Product extends DataSet {
    private String name;
    @OneToMany
    private List<Ingridient> ingridients = new ArrayList<>();
    private Long cost= Long.valueOf(0);
    private Long price= Long.valueOf(0);
    private Integer weight;
    private Integer nds;//величина ндс
    private String pica;//единица измерения кг/шт
    private Integer order = 0;
}

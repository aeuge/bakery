package ru.aeuge.bakery.dataset;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Invoice extends DataSet {
    private Integer number;
    private Date date;
    @ManyToOne
    private Users user;
    private List<Product> products;
    private Long sum = Long.valueOf(0);
}

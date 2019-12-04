package group.orda.kymyz.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
@SequenceGenerator(name = "OrderSequence", sequenceName = "order_seq", allocationSize = 1)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderSequence")
    private Long id;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column
    private Date date;
    @Column
    private Long fullCups;
    @Column
    private Long halfCups;

    public enum Status {
        INQUEUE, INPROCESS, DONE
    }
}

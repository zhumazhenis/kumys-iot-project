package group.orda.kymyz.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "order_entries")
@SequenceGenerator(name = "OrderEntrySequence", sequenceName = "order_entry_seq", allocationSize = 1)
public class OrderEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderEntrySequence")
    private Long id;
    @Column
    private Long index;
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Order order;

    public enum Type {
        HALF, FULL
    }

    public enum Status {
        INQUEUE, PUTTED, FILLED, SORTED
    }
}

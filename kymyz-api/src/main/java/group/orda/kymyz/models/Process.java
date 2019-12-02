package group.orda.kymyz.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "processes")
@SequenceGenerator(name = "ProcessSequence", sequenceName = "process_seq", allocationSize = 1)
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProcessSequence")
    private Long id;
    @Column
    private Date date;
}

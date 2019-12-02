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
@Table(name = "measurements")
@SequenceGenerator(name = "MeasurementSequence", sequenceName = "measurement_seq", allocationSize = 1)
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MeasurementSequence")
    private Long id;
    @Column
    private Date date;
}

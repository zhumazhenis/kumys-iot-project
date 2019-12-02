package group.orda.kymyz.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "measurement_properties")
@SequenceGenerator(name = "MeasurementPropertySequence", sequenceName = "measurement_property_seq", allocationSize = 1)
public class MeasurementProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MeasurementPropertySequence")
    private Long id;
    @ManyToOne
    private Measurement measurement;
    @Column
    private String name;
    @Column
    private String value;
}

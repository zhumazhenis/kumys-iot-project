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
@Table(name = "instruction_properties")
@SequenceGenerator(name = "InstructionPropertySequence", sequenceName = "instruction_property_seq", allocationSize = 1)
public class InstructionProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InstructionPropertySequence")
    private Long id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne
    private Instruction instruction;

    public enum Type {
        NUMBER, STRING
    }
}

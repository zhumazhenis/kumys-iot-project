package group.orda.kymyz.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "instructions")
@SequenceGenerator(name = "InstructionSequence", sequenceName = "instruction_seq", allocationSize = 1)
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InstructionSequence")
    private Long id;
    @Column
    private String name;
}

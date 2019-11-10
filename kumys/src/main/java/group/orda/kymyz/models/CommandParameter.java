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
@Table(name = "command_parameters")
@SequenceGenerator(name = "CommandParameterSequence", sequenceName = "command_parameter_seq", allocationSize = 1)
public class CommandParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CommandParameterSequence")
    private Long id;
    @ManyToOne
    private Command command;
    @ManyToOne
    private InstructionProperty instructionProperty;
    @Column
    private String value;
}

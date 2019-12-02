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
import java.util.Date;

@Data
@Entity
@Table(name = "commands")
@SequenceGenerator(name = "CommandSequence", sequenceName = "command_seq", allocationSize = 1)
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CommandSequence")
    private Long id;
    @ManyToOne
    private Instruction instruction;
    @ManyToOne
    private Process process;
    @Column
    private Date date;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column
    private String message;

    public enum Status {
        COMPLETE, INCOMPLETE, ERROR
    }
}

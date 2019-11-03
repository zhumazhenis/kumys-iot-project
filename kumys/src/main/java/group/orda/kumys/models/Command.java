package group.orda.kumys.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "commands")
@SequenceGenerator(name = "CommandSequence", sequenceName = "command_seq", allocationSize = 1)
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CommandSequence")
    private Long id;
}

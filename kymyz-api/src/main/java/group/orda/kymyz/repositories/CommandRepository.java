package group.orda.kymyz.repositories;

import group.orda.kymyz.models.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {
    List<Command> findAllByProcessId(Long processId);
}

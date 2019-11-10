package group.orda.kymyz.repositories;

import group.orda.kymyz.models.CommandParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandParameterRepository extends JpaRepository<CommandParameter, Long> {
    List<CommandParameter> findAllByCommandId(Long commandId);
}

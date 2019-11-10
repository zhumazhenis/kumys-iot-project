package group.orda.kymyz.repositories;

import group.orda.kymyz.models.InstructionProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructionPropertyRepository extends JpaRepository<InstructionProperty, Long> {
    List<InstructionProperty> findAllByInstructionId(Long instructionId);
}

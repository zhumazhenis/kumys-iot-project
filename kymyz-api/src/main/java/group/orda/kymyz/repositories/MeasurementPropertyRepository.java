package group.orda.kymyz.repositories;

import group.orda.kymyz.models.MeasurementProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementPropertyRepository extends JpaRepository<MeasurementProperty, Long> {
    List<MeasurementProperty> findAllByMeasurementId(Long measurementId);
}

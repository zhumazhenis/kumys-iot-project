package group.orda.kymyz.repositories;

import group.orda.kymyz.models.OrderEntry;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderEntryRepository extends JpaRepository<OrderEntry, Long> {
    Optional<OrderEntry> findFirstByOrderIdAndIndex(Long orderId, Long index);

    List<OrderEntry> findAllByOrderId(Long orderId, Sort sort);
}

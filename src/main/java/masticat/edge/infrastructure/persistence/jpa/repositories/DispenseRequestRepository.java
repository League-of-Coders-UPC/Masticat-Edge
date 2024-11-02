package masticat.edge.infrastructure.persistence.jpa.repositories;

import java.util.Optional;
import masticat.edge.domain.model.entities.DispenseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispenseRequestRepository extends JpaRepository<DispenseRequest, Long> {

  Optional<DispenseRequest> findByDeviceUuid(String deviceUuid);
}

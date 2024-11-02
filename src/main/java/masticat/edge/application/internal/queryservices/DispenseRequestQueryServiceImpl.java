package masticat.edge.application.internal.queryservices;

import java.util.Optional;
import masticat.edge.domain.model.entities.DispenseRequest;
import masticat.edge.domain.model.queries.GetDispenseRequestByDeviceUuidQuery;
import masticat.edge.domain.model.queries.GetDispenseRequestByIdQuery;
import masticat.edge.domain.services.DispenseRequestQueryService;
import masticat.edge.infrastructure.persistence.jpa.repositories.DispenseRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispenseRequestQueryServiceImpl implements DispenseRequestQueryService {

  @Autowired
  private DispenseRequestRepository dispenseRequestRepository;

  @Override
  public Optional<DispenseRequest> handle(GetDispenseRequestByIdQuery query) {
    return dispenseRequestRepository.findById(query.id());
  }

  @Override
  public Optional<DispenseRequest> handle(GetDispenseRequestByDeviceUuidQuery query) {
    return dispenseRequestRepository.findByDeviceUuid(query.deviceUuid());
  }
}

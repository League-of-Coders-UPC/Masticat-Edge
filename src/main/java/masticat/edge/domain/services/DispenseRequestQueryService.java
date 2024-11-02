package masticat.edge.domain.services;

import java.util.Optional;
import masticat.edge.domain.model.entities.DispenseRequest;
import masticat.edge.domain.model.queries.GetDispenseRequestByDeviceUuidQuery;
import masticat.edge.domain.model.queries.GetDispenseRequestByIdQuery;

public interface DispenseRequestQueryService {

  Optional<DispenseRequest> handle(GetDispenseRequestByIdQuery query);

  Optional<DispenseRequest> handle(GetDispenseRequestByDeviceUuidQuery query);

}

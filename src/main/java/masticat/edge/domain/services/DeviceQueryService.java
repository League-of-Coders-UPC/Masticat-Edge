package masticat.edge.domain.services;

import java.util.Optional;
import masticat.edge.domain.model.entities.Device;
import masticat.edge.domain.model.queries.GetDeviceByMacAddressQuery;

public interface DeviceQueryService {

  Optional<Device> handle(GetDeviceByMacAddressQuery query);
}

package masticat.edge.domain.services;

import java.util.Optional;
import masticat.edge.domain.model.commands.CreateDispenseRequestCommand;
import masticat.edge.domain.model.entities.Device;

public interface DispenseRequestCommandService {

  Optional<Device> handle(CreateDispenseRequestCommand command);
}

package masticat.edge.domain.services;

import masticat.edge.domain.model.commands.CreateDispenseRequestCommand;
import masticat.edge.domain.model.commands.DeleteDispenseRequestCommand;

public interface DispenseRequestCommandService {

  Long handle(CreateDispenseRequestCommand command);

  void handle(DeleteDispenseRequestCommand command);

}

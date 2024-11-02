package masticat.edge.interfaces.rest.transform;

import masticat.edge.domain.model.commands.CreateDispenseRequestCommand;
import masticat.edge.interfaces.rest.resources.CreateDispenseRequestResource;

public class CreateDispenseRequestCommandFromResourceAssembler {

  public static CreateDispenseRequestCommand toCommandFromResource(
      CreateDispenseRequestResource resource) {
    return new CreateDispenseRequestCommand(resource.deviceUuid(), resource.type(), resource.amount());
  }

}

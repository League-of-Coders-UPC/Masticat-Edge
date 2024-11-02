package masticat.edge.interfaces.rest.transform;

import masticat.edge.domain.model.entities.DispenseRequest;
import masticat.edge.interfaces.rest.resources.DispenseRequestResource;

public class DispenseRequestResourceFromEntityAssembler {

  public static DispenseRequestResource toResourceFromEntity(
      DispenseRequest dispenseRequest) {
    return new DispenseRequestResource(dispenseRequest.getDeviceUuid(), dispenseRequest.getType(), dispenseRequest.getAmount());
  }

}

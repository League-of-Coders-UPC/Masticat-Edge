package masticat.edge.interfaces.rest.transform;

import masticat.edge.domain.model.entities.Device;
import masticat.edge.interfaces.rest.resources.DeviceResource;

public class DeviceResourceFromEntityAssembler {

  public static DeviceResource toResourceFromEntity(Device device) {
    return new DeviceResource(device.getId(), device.getSerialNumber(), device.getStatus(), device.getFoodQuantity(),
        device.getWaterQuantity(), device.getFoodLimit(), device.getWaterLimit());
  }

}

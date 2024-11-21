package masticat.edge.interfaces.rest;




import java.util.Optional;
import masticat.edge.domain.model.entities.Device;
import masticat.edge.domain.model.queries.GetDeviceByMacAddressQuery;
import masticat.edge.domain.services.DeviceQueryService;
import masticat.edge.interfaces.rest.resources.DeviceResource;
import masticat.edge.interfaces.rest.transform.DeviceResourceFromEntityAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/v1/device", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeviceController {

  @Autowired
  private DeviceQueryService deviceQueryService;

  @GetMapping
  public ResponseEntity<DeviceResource> getDeviceByMacAddress(@RequestParam String macAddress){
    GetDeviceByMacAddressQuery getDeviceByMacAddressQuery = new GetDeviceByMacAddressQuery(macAddress);
    Optional<Device> device = deviceQueryService.handle(getDeviceByMacAddressQuery);

    if(device.isEmpty()){
      return ResponseEntity.badRequest().build();
    }

    DeviceResource deviceResource = DeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());
    return new ResponseEntity<>(deviceResource, HttpStatus.CREATED);
  }
}

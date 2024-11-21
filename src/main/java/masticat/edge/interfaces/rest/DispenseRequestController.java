package masticat.edge.interfaces.rest;

import java.util.Optional;
import masticat.edge.domain.model.commands.CreateDispenseRequestCommand;
import masticat.edge.domain.model.entities.Device;
import masticat.edge.domain.services.DispenseRequestCommandService;
import masticat.edge.interfaces.rest.resources.CreateDispenseRequestResource;
import masticat.edge.interfaces.rest.resources.DeviceResource;
import masticat.edge.interfaces.rest.transform.CreateDispenseRequestCommandFromResourceAssembler;
import masticat.edge.interfaces.rest.transform.DeviceResourceFromEntityAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/v1/dispense-request", produces = MediaType.APPLICATION_JSON_VALUE)
public class DispenseRequestController {

  @Autowired
  private DispenseRequestCommandService dispenseRequestCommandService;

  @PostMapping
  public ResponseEntity<DeviceResource> createDispenseRequest(@RequestBody CreateDispenseRequestResource createDispenseRequestResource){
    CreateDispenseRequestCommand createDispenseRequestCommand = CreateDispenseRequestCommandFromResourceAssembler.toCommandFromResource(createDispenseRequestResource);
    Optional<Device> device = dispenseRequestCommandService.handle(createDispenseRequestCommand);
    if(device.isEmpty()){
      return ResponseEntity.badRequest().build();
    }

    DeviceResource deviceResource = DeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());

    return new ResponseEntity<>(deviceResource, HttpStatus.CREATED);
  }
}

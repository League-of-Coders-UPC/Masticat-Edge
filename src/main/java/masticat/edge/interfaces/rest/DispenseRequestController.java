package masticat.edge.interfaces.rest;

import java.util.Optional;
import masticat.edge.domain.model.commands.CreateDispenseRequestCommand;
import masticat.edge.domain.model.commands.DeleteDispenseRequestCommand;
import masticat.edge.domain.model.entities.DispenseRequest;
import masticat.edge.domain.model.queries.GetDispenseRequestByDeviceUuidQuery;
import masticat.edge.domain.model.queries.GetDispenseRequestByIdQuery;
import masticat.edge.domain.services.DispenseRequestCommandService;
import masticat.edge.domain.services.DispenseRequestQueryService;
import masticat.edge.interfaces.rest.resources.CreateDispenseRequestResource;
import masticat.edge.interfaces.rest.resources.DispenseRequestResource;
import masticat.edge.interfaces.rest.transform.CreateDispenseRequestCommandFromResourceAssembler;
import masticat.edge.interfaces.rest.transform.DispenseRequestResourceFromEntityAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @Autowired
  private DispenseRequestQueryService dispenseRequestQueryService;

  @GetMapping("/{deviceUuid}")
  public ResponseEntity<DispenseRequestResource> getDispenseRequestByDeviceUuid(@PathVariable String deviceUuid){
    GetDispenseRequestByDeviceUuidQuery getDispenseRequestByDeviceUuidQuery = new GetDispenseRequestByDeviceUuidQuery(deviceUuid);
    Optional<DispenseRequest> dispenseRequest = dispenseRequestQueryService.handle(getDispenseRequestByDeviceUuidQuery);
    if(dispenseRequest.isEmpty()){
      return ResponseEntity.notFound().build();
    }

    DispenseRequestResource dispenseRequestResource = DispenseRequestResourceFromEntityAssembler.toResourceFromEntity(dispenseRequest.get());

    DeleteDispenseRequestCommand deleteDispenseRequestCommand = new DeleteDispenseRequestCommand(dispenseRequest.get().getId());

    dispenseRequestCommandService.handle(deleteDispenseRequestCommand);

    return ResponseEntity.ok(dispenseRequestResource);
  }

  @PostMapping
  public ResponseEntity<DispenseRequestResource> createDispenseRequest(@RequestBody CreateDispenseRequestResource createDispenseRequestResource){
    CreateDispenseRequestCommand createDispenseRequestCommand = CreateDispenseRequestCommandFromResourceAssembler.toCommandFromResource(createDispenseRequestResource);
    Long dispenseRequestId = dispenseRequestCommandService.handle(createDispenseRequestCommand);
    if(dispenseRequestId == 0L){
      return ResponseEntity.badRequest().build();
    }
    GetDispenseRequestByIdQuery getDispenseRequestByIdQuery = new GetDispenseRequestByIdQuery(dispenseRequestId);
    Optional<DispenseRequest> dispenseRequest = dispenseRequestQueryService.handle(getDispenseRequestByIdQuery);
    if(dispenseRequest.isEmpty()){
      return ResponseEntity.badRequest().build();
    }

    DispenseRequestResource dispenseRequestResource = DispenseRequestResourceFromEntityAssembler.toResourceFromEntity(dispenseRequest.get());

    return new ResponseEntity<>(dispenseRequestResource, HttpStatus.CREATED);
  }
}

package masticat.edge.application.internal.commandservices;

import masticat.edge.domain.model.commands.CreateDispenseRequestCommand;
import masticat.edge.domain.model.commands.DeleteDispenseRequestCommand;
import masticat.edge.domain.model.entities.DispenseRequest;
import masticat.edge.domain.services.DispenseRequestCommandService;
import masticat.edge.infrastructure.persistence.jpa.repositories.DispenseRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispenseRequestCommandServiceImpl implements DispenseRequestCommandService {

  @Autowired
  private DispenseRequestRepository dispenseRequestRepository;

  @Override
  public Long handle(CreateDispenseRequestCommand command) {
    DispenseRequest dispenseRequest = new DispenseRequest();
    dispenseRequest.setType(command.type());
    dispenseRequest.setDeviceUuid(command.deviceUuid());
    dispenseRequest.setAmount(command.amount());
    dispenseRequestRepository.save(dispenseRequest);
    return dispenseRequest.getId();
  }

  @Override
  public void handle(DeleteDispenseRequestCommand command) {
    dispenseRequestRepository.deleteById(command.id());
  }

}

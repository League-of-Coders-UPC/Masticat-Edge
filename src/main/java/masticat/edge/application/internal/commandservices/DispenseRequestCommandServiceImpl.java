package masticat.edge.application.internal.commandservices;

import java.util.Optional;
import masticat.edge.application.internal.utils.EdgeUtils;
import masticat.edge.domain.model.commands.CreateDispenseRequestCommand;
import masticat.edge.domain.model.entities.Device;
import masticat.edge.domain.model.entities.DispenseRequest;
import masticat.edge.domain.services.DispenseRequestCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DispenseRequestCommandServiceImpl implements DispenseRequestCommandService {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public Optional<Device> handle(CreateDispenseRequestCommand command) {

    String apiKey = EdgeUtils.getApiKey();

    DispenseRequest dispenseRequest = new DispenseRequest(command.deviceId(), command.type(), command.quantity(), command.action());

    HttpHeaders headers = new HttpHeaders();
    headers.set("iot-device-api-key", apiKey);
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<DispenseRequest> entity = new HttpEntity<>(dispenseRequest, headers);

    String url = "https://animal-shelter-p65z.onrender.com/api/update-device-quantity/";

    try {
      ResponseEntity<Device> response = restTemplate.exchange(
          url,
          HttpMethod.POST,
          entity,
          Device.class
      );

      return Optional.ofNullable(response.getBody());
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }

  }

}

package masticat.edge.application.internal.queryservices;

import java.util.Optional;
import masticat.edge.application.internal.utils.EdgeUtils;
import masticat.edge.domain.model.entities.Device;
import masticat.edge.domain.model.queries.GetDeviceByMacAddressQuery;
import masticat.edge.domain.model.queries.GetDeviceByUuIdQuery;
import masticat.edge.domain.services.DeviceQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeviceQueryServiceImpl implements DeviceQueryService {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public Optional<Device> handle(GetDeviceByMacAddressQuery query) {

    String apiKey = EdgeUtils.getApiKey();

    HttpHeaders headers = new HttpHeaders();
    headers.set("iot-device-api-key", apiKey);

    HttpEntity<String> entity = new HttpEntity<>(headers);

    String url = "https://animal-shelter-p65z.onrender.com/api/devices?serial_number=" + query.macAddress();

    ResponseEntity<Device[]> response = restTemplate.exchange(
        url,
        HttpMethod.GET,
        entity,
        Device[].class
    );

    Device[] devices = response.getBody();

    return devices != null && devices.length > 0 ? Optional.of(devices[0]) : Optional.empty();
  }
}

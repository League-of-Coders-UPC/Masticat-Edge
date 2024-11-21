package masticat.edge.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import masticat.edge.domain.model.valueobjects.DispenseRequestAction;
import masticat.edge.domain.model.valueobjects.DispenseRequestType;

@Getter
@Setter
public class DispenseRequest {

  @JsonProperty("device_id")
  private String deviceId;

  @Enumerated(EnumType.STRING)
  private DispenseRequestType type;

  private Float quantity;

  @Enumerated(EnumType.STRING)
  private DispenseRequestAction action;

  public DispenseRequest(String deviceId, DispenseRequestType type, Float quantity,
      DispenseRequestAction action) {
    this.deviceId = deviceId;
    this.type = type;
    this.quantity = quantity;
    this.action = action;
  }

  public DispenseRequest() {

  }
}

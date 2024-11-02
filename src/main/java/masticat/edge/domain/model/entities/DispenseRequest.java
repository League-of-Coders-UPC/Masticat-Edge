package masticat.edge.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import masticat.edge.domain.model.valueobjects.DispenseRequestType;

@Entity
@Getter
@Setter
public class DispenseRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String deviceUuid;

  @Enumerated(EnumType.STRING)
  private DispenseRequestType type;

  private Float amount;

  public DispenseRequest(String deviceUuid, DispenseRequestType type, Float amount) {
    this.deviceUuid = deviceUuid;
    this.type = type;
    this.amount = amount;
  }

  public DispenseRequest() {

  }
}

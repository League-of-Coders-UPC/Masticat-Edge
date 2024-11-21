package masticat.edge.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Device {

  private String id;

  @JsonProperty("serial_number")
  private String serialNumber;

  private String status;

  @JsonProperty("food_quantity")
  private Float foodQuantity;

  @JsonProperty("water_quantity")
  private Float waterQuantity;

  @JsonProperty("battery_quantity")
  private Float batteryQuantity;

  @JsonProperty("food_limit")
  private Float foodLimit;

  @JsonProperty("water_limit")
  private Float waterLimit;

  public Device() {}
}

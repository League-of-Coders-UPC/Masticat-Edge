package masticat.edge.interfaces.rest.resources;

import masticat.edge.domain.model.valueobjects.DispenseRequestAction;
import masticat.edge.domain.model.valueobjects.DispenseRequestType;

public record CreateDispenseRequestResource(String deviceId, DispenseRequestType type, Float quantity, DispenseRequestAction action) {
}

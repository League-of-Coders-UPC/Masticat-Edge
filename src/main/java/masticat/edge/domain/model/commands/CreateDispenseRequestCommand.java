package masticat.edge.domain.model.commands;

import masticat.edge.domain.model.valueobjects.DispenseRequestAction;
import masticat.edge.domain.model.valueobjects.DispenseRequestType;

public record CreateDispenseRequestCommand(String deviceId, DispenseRequestType type, Float quantity, DispenseRequestAction action) {

}

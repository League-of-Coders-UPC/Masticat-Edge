package masticat.edge.domain.model.commands;

import masticat.edge.domain.model.valueobjects.DispenseRequestType;

public record CreateDispenseRequestCommand(String deviceUuid, DispenseRequestType type, Float amount) {

}

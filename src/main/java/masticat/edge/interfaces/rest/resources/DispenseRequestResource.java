package masticat.edge.interfaces.rest.resources;

import masticat.edge.domain.model.valueobjects.DispenseRequestType;

public record DispenseRequestResource(String deviceUuid, DispenseRequestType type, Float amount) {

}

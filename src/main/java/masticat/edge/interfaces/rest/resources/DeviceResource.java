package masticat.edge.interfaces.rest.resources;

public record DeviceResource(String id, String serialNumber, String status, Float food_quantity, Float water_quantity,
                             Float food_limit, Float water_limit) {

}

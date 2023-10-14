package org.eval.moretech.routes.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RouteToPlaceRequest extends FindNearestRequest {
    private PlaceDto to;
    private TransportType transport;
}

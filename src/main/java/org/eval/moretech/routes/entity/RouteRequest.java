package org.eval.moretech.routes.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RouteRequest {

    Point from;
    Point to;

    TransportType transportType;
}

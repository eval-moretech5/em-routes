package org.eval.moretech.routes.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EnrichedRoute extends RouteResponse.Route {

    private String id;

    private Long placeId;

    private Integer lineDuration;
    private Integer fullDuration;
    private String textFullDuration;
}

package org.eval.moretech.routes.mapper;

import org.eval.moretech.routes.entity.EnrichedRoute;
import org.eval.moretech.routes.entity.RouteResponse;
import org.mapstruct.Mapper;

@Mapper
public abstract class RouteMapper {

    public abstract EnrichedRoute map(RouteResponse.Route route);
}

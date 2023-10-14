package org.eval.moretech.routes.controller;

import lombok.RequiredArgsConstructor;
import org.eval.moretech.routes.entity.EnrichedRoute;
import org.eval.moretech.routes.entity.RouteToPlaceRequest;
import org.eval.moretech.routes.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    public List<EnrichedRoute> getRoutes(@RequestBody RouteToPlaceRequest request) {
        return routeService.findRoutes(request);
    }
}

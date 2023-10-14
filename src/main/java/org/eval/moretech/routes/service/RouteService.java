package org.eval.moretech.routes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eval.moretech.routes.entity.*;
import org.eval.moretech.routes.feign.PlaceClient;
import org.eval.moretech.routes.feign.RouteClient;
import org.eval.moretech.routes.mapper.RouteMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class RouteService {

    private final PlaceClient placeClient;
    private final RouteClient routeClient;
    private final RouteMapper routeMapper;
    @Value("${branches.limit}")
    private final Integer placesLimit;

    public List<EnrichedRoute> findRoutes(RouteToPlaceRequest request) {
        List<EnrichedRoute> result = new ArrayList<>();

        List<PlaceDto> branches;

        if (Objects.nonNull(request.getTo())) {
            branches = List.of(request.getTo());
        } else {
            FindNearestRequest branchesRequest = FindNearestRequest.builder()
                .from(request.getFrom())
                .lowMobility(request.getLowMobility())
                .personType(request.getPersonType())
                .services(request.getServices())
                .premium(request.getPremium())
                .radius(request.getRadius())
                .limit(placesLimit)
                .build();
            branches = placeClient.findNearest(branchesRequest);
        }

        for (PlaceDto placeDto : branches) {
            result.addAll(findRoutes(request.getFrom(), placeDto, request.getTransport()));
        }

        result.sort(Comparator.comparingInt(EnrichedRoute::getFullDuration));

        result = result.subList(0, Math.min(6, result.size()));

        return result;
    }

    public List<EnrichedRoute> findRoutes(Point from, PlaceDto to, TransportType transportType) {
        List<EnrichedRoute> result = new ArrayList<>();

        RouteResponse routeResponse;
        try {
            routeResponse = routeClient.getRoutes(
                RouteRequest.builder()
                    .from(from)
                    .to(to.getPoint())
                    .transportType(transportType)
                    .build()
            );
        } catch (Throwable e) {
            routeResponse = new RouteResponse();
            routeResponse.setRoutes(List.of());
            log.error("Something went wrong", e);
        }

        for (RouteResponse.Route route : routeResponse.getRoutes()) {
            EnrichedRoute enrichedRoute = routeMapper.map(route);
            enrichedRoute.setLineDuration(to.getLineTime());
            enrichedRoute.setPlaceId(to.getId());
            enrichedRoute.setFullDuration(
                enrichedRoute.getDuration() + enrichedRoute.getLineDuration()
            );
            enrichedRoute.setTextFullDuration(
                //TODO Когда-нибудь может быть доделать до часов
                Math.round(enrichedRoute.getFullDuration().doubleValue() / 60) + " мин"
            );
            enrichedRoute.setId(UUID.randomUUID().toString());

            result.add(enrichedRoute);
        }

        return result;
    }
}

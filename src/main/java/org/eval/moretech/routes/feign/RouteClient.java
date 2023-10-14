package org.eval.moretech.routes.feign;

import org.eval.moretech.routes.entity.RouteRequest;
import org.eval.moretech.routes.entity.RouteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "routesApi", url = "${route-adapter.url}")
public interface RouteClient {

    @PostMapping("/api/v1/routes")
    RouteResponse getRoutes(@RequestBody RouteRequest request);
}

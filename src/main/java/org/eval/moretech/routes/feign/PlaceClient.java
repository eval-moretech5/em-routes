package org.eval.moretech.routes.feign;

import org.eval.moretech.routes.entity.FindNearestRequest;
import org.eval.moretech.routes.entity.PlaceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "branchesApi", url = "${branches.url}")
public interface PlaceClient {

    @GetMapping("/api/v1/places/poor")
    List<PlaceDto> findNearest(@RequestBody FindNearestRequest request);
}

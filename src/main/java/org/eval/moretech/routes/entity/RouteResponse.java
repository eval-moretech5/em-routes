package org.eval.moretech.routes.entity;

import lombok.Data;

import java.util.List;

@Data
public class RouteResponse {

    private String status;
    private List<Route> routes;

    @Data
    public static class Route {
        private String textDistance;
        private Integer distance;
        private String textDuration;
        private Integer duration;
        private List<Maneuver> maneuvers;
    }

    @Data
    public static class Maneuver {
        private String type;
        private String comment;
        private String pathComment;
        private Integer distance;
        private Integer duration;
        private List<Geometry> chunks;
    }

    @Data
    public static class Geometry {
        private String color;
        private List<Point> points;
    }
}

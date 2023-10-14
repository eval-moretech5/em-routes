package org.eval.moretech.routes.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Point {
    private Double lon;
    private Double lat;
}

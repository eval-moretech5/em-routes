package org.eval.moretech.routes.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDto {
    private Long id;
    private Integer lineTime;
    private Point point;
}

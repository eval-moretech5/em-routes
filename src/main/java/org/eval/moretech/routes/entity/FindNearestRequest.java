package org.eval.moretech.routes.entity;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindNearestRequest {
    private Point from;
    private Boolean lowMobility;
    private PersonType personType;
    private List<ServiceType> services;
    private Boolean premium;
    private Integer radius;
    private Integer limit;
}

package com.jm.jimnisbakery.domain.breads.dto;

import lombok.Data;

@Data
public class UpdateBreadRequest {
    private Long breadId;
    private String title;
    private String description;
    private Integer remainingQuantity;
    private String thumbnailUrl;
    private Float reviewRating;
}

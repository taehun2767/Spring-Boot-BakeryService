package com.jm.jimnisbakery.web.message;

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

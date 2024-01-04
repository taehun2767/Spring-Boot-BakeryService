package com.jm.jimnisbakery.domain.breads.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateBreadRequest {
    private String title;
    private String description;
    private Integer remainingQuantity;
    private String thumbnailUrl;
    private Float reviewRating;
    private String createdBy;
 }

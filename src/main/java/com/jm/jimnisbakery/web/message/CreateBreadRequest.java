package com.jm.jimnisbakery.web.message;

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

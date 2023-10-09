package com.jm.jimnisbakery.web.dto;

import com.jm.jimnisbakery.domain.breads.Bread;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class BreadDto {
    public String breadHashId;
    public String title;
    public String description;
    public String thumbnailUrl;
    public Float reviewRating;
    public Integer remainingQuantity;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public String createdBy;

    public BreadDto(String breadHashId, String title, String description, String thumbnailUrl, Float reviewRating, Integer remainingQuantity, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy){
        this.breadHashId = breadHashId;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.reviewRating = reviewRating;
        this.remainingQuantity = remainingQuantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
    }

    public BreadDto(Bread bread){
        breadHashId = Bread.EncodeId(bread.getId());
        title = bread.getTitle();
        description = bread.getDescription();
        thumbnailUrl = bread.getThumbnailUrl();
        reviewRating = bread.getReviewRating();
        remainingQuantity = bread.getRemainingQuantity();
        createdAt = bread.getCreatedAt();
        updatedAt = bread.getUpdatedAt();
        createdBy = bread.getCreatedBy();
    }
}

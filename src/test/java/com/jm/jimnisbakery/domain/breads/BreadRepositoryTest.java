package com.jm.jimnisbakery.domain.breads;

import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


    @RunWith(SpringRunner.class)
    @SpringBootTest
    @Transactional
public class BreadRepositoryTest {

    @Autowired
    BreadRepository breadRepository;

    @Test
    @DisplayName("빵 생성")
    public void CreateBread() {
        String title = "title test";
        String description = "description test";
        String thumbnailUrl = "thumbnailUrl test";
        Integer remainingQuantity = 1;
        Float reviewRating = 4.9F;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();
        String createdBy = "admin";


        Bread insertedBread = breadRepository.save(Bread.builder()
                        .title(title)
                        .description(description)
                        .thumbnailUrl(thumbnailUrl)
                        .remainingQuantity(remainingQuantity)
                        .reviewRating(reviewRating)
                        .createdAt(createdAt)
                        .updatedAt(updatedAt)
                        .createdBy(createdBy)
                        .build());
        Bread bread = breadRepository.findById(insertedBread.getId()).orElse(null);

        if(bread == null)
            fail("failed to insert bread");

        assertThat(bread.getTitle()).isEqualTo(title);
        assertThat(bread.getDescription()).isEqualTo(description);
        assertThat(bread.getThumbnailUrl()).isEqualTo(thumbnailUrl);
        assertThat(bread.getRemainingQuantity()).isEqualTo(remainingQuantity);
        assertThat(bread.getReviewRating()).isEqualTo(reviewRating);
        assertThat(bread.getCreatedBy()).isEqualTo(createdBy);
    }
}

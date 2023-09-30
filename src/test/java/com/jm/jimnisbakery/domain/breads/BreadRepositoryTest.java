package com.jm.jimnisbakery.domain.breads;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


    @RunWith(SpringRunner.class)
    @SpringBootTest
public class BreadRepositoryTest {
    @Autowired
    BreadRepository breadRepository;

    @Test
    @DisplayName("빵 생성")
    public void createBread() {
        String title = "title test";
        String description = "description test";
        String thumbnailUrl = "thumbnailUrl test";
        Integer viewOrder = 1;
        LocalDate createdAt = LocalDate.now();
        LocalDate updatedAt = LocalDate.now();
        String createdBy = "admin";


        Bread insertedBread = breadRepository.save(Bread.builder()
                        .title(title)
                        .description(description)
                        .thumbnailUrl(thumbnailUrl)
                        .viewOrder(viewOrder)
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
        assertThat(bread.getViewOrder()).isEqualTo(viewOrder);
        assertThat(bread.getCreatedAt()).isEqualTo(createdAt);
        assertThat(bread.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(bread.getCreatedBy()).isEqualTo(createdBy);
    }
}

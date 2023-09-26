package com.jm.jimnisbakery.domain.breads;

import org.junit.Test;
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
public class BreadsRepositoryTest {
    @Autowired
    BreadsRepository breadsRepository;

    @Test
    public void InsertBreadTest() {
        String title = "title test";
        String description = "description test";
        String thumbnailUrl = "thumbnailUrl test";
        Integer viewOrder = 1;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();
        String createdBy = "admin";


        Breads insertedBread = breadsRepository.save(Breads.builder()
                        .title(title)
                        .description(description)
                        .thumbnailUrl(thumbnailUrl)
                        .viewOrder(viewOrder)
                        .createdAt(createdAt)
                        .updatedAt(updatedAt)
                        .createdBy(createdBy)
                        .build());
        Breads bread = breadsRepository.findById(insertedBread.getId()).orElse(null);

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

package com.jm.jimnisbakery.domain.breads;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BreadsRepositoryTest {
    @Autowired
    BreadsRepository breadsRepository;

    @Test
    public void InsertBreadTest() {
        Long userId = 1L;
        String title = "title test";
        String description = "description test";
        String thumbnailUrl = "thumbnailUrl test";
        Integer viewOrder = 1;
        LocalDate createdAt = LocalDate.now();
        LocalDate updatedAt = LocalDate.now();


        Breads insertedBread = breadsRepository.save(Breads.builder()
                        .userId(userId)
                        .title(title)
                        .description(description)
                        .thumbnailUrl(thumbnailUrl)
                        .viewOrder(viewOrder)
                        .createdAt(createdAt)
                        .updatedAt(updatedAt)
                        .build());
        Breads bread = breadsRepository.findById(insertedBread.getId()).orElse(null);

        if(bread == null)
            fail("failed to insert bread");

        assertThat(bread.getUserId()).isEqualTo(userId);
        assertThat(bread.getTitle()).isEqualTo(title);
        assertThat(bread.getDescription()).isEqualTo(description);
        assertThat(bread.getThumbnailUrl()).isEqualTo(thumbnailUrl);
        assertThat(bread.getViewOrder()).isEqualTo(viewOrder);
        assertThat(bread.getCreatedAt()).isEqualTo(createdAt);
        assertThat(bread.getUpdatedAt()).isEqualTo(updatedAt);

    }
}

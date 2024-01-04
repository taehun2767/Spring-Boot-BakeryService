package com.jm.jimnisbakery.domain.comments;

import com.jm.jimnisbakery.domain.breads.domain.Bread;
import com.jm.jimnisbakery.domain.breads.dao.BreadRepository;
import com.jm.jimnisbakery.domain.comments.dao.CommentRepository;
import com.jm.jimnisbakery.domain.comments.domain.Comment;
import com.jm.jimnisbakery.domain.users.domain.User;
import com.jm.jimnisbakery.domain.users.dao.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BreadRepository breadRepository;

    @Test
    @DisplayName("댓글 생성")
    public void CreateCommentTest() {
        String name = "ted";
        String loginToken = "testToken";
        String email = "test@snu.ac.kr";
        String snsId = "test@naver.com";
        String phoneNumber = "010-0000-0000";
        String address = "testAddress";

        User user = userRepository.save(User.builder()
                .name(name)
                .loginToken(loginToken)
                .email(email)
                .snsId(snsId)
                .phoneNumber(phoneNumber)
                .address(address)
                .build());

        String title = "title test";
        String description = "description test";
        String thumbnailUrl = "thumbnailUrl test";
        Integer remainingQuantity = 1;
        Float reviewRating = 4.7F;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();
        String createdBy = "admin";


        Bread bread = breadRepository.save(Bread.builder()
                .title(title)
                .description(description)
                .thumbnailUrl(thumbnailUrl)
                .remainingQuantity(remainingQuantity)
                .reviewRating(reviewRating)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .createdBy(createdBy)
                .build());


        Comment comment = commentRepository.save(Comment.builder()
                        .user(user)
                        .bread(bread)
                        .content("content")
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build());

        Comment insertedComment = commentRepository.getReferenceById(comment.getId());
        assertThat(comment.getId()).isEqualTo(insertedComment.getId());
        assertThat(comment.getUser().getId()).isEqualTo(insertedComment.getUser().getId());
        assertThat(comment.getBread().getId()).isEqualTo(insertedComment.getBread().getId());

    }
}

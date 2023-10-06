package com.jm.jimnisbakery.dto;

import com.jm.jimnisbakery.domain.breads.Bread;
import com.jm.jimnisbakery.domain.comments.Comment;
import com.jm.jimnisbakery.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class CommentDto {
    public String commentHashId;
    public User user;
    public Bread bread;
    public String description;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public CommentDto(String commentHashId, User user, Bread bread, String description, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.commentHashId = commentHashId;
        this.user = user;
        this.bread = bread;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CommentDto(Comment comment){
        commentHashId = Comment.EncodeId(comment.getId());
        user = comment.getUser();
        bread = comment.getBread();
        description = comment.getDescription();
        createdAt = comment.getCreatedAt();
        updatedAt = comment.getUpdatedAt();
    }
}

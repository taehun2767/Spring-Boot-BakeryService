package com.jm.jimnisbakery.web.dto;

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
    public String content;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public CommentDto(String commentHashId, User user, Bread bread, String content, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.commentHashId = commentHashId;
        this.user = user;
        this.bread = bread;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CommentDto(Comment comment){
        commentHashId = Comment.EncodeId(comment.getId());
        user = comment.getUser();
        bread = comment.getBread();
        content = comment.getContent();
        createdAt = comment.getCreatedAt();
        updatedAt = comment.getUpdatedAt();
    }
}

package com.jm.jimnisbakery.domain.comments.dao;

import com.jm.jimnisbakery.domain.comments.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

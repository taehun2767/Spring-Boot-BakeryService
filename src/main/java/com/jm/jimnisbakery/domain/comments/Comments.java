package com.jm.jimnisbakery.domain.comments;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long breadId;

    @Column(length = 200)
    private String description;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder Comments(Long userId, Long breadId, String description, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.userId = userId;
        this. breadId = breadId;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

package com.jm.jimnisbakery.domain.comments;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Length;

import java.time.LocalDate;

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

    @Column
    private LocalDate createdAt;

    @Column
    private LocalDate updatedAt;

    @Builder Comments(Long userId, Long breadId, String description, LocalDate createdAt, LocalDate updatedAt){
        this.userId = userId;
        this. breadId = breadId;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
